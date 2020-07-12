package Lesson6;

import Lesson4.Cat;

public class Tree {
    // travers
    // delete
    String treeName;

    public Tree(String treeName) {
        this.treeName = treeName;
    }

    private class TreeNode implements Comparable {
        private Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat))
                throw new ClassCastException("Not a cat");
            return c.getAge() - ((Cat) o).getAge();
        }
    }

    TreeNode root;

    public void insert(Cat c, int depth){
        if (root == null) {
            insert(c);
        }else {
            while (Math.max(depth(root.right), depth(root.left)) != depth){
                insert(c);
            }
        }
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.c.getAge() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    private void postOrderTravers(TreeNode current){
        if(current != null){
            postOrderTravers(current.left);
            postOrderTravers(current.right);
            System.out.print(current.c.getAge() + " ");
        }
    }

    private void inOrderTravers(TreeNode current){
        if(current != null){
            inOrderTravers(current.left);
            System.out.print(current.c.getAge() + " ");
            inOrderTravers(current.right);
        }
    }




    public void displayTree() {
        System.out.println("Tree: " + treeName);
        System.out.println("preOrderTraverse");
        preOrderTraverse(root);
//        System.out.println("\npostOrderTravers");
//        postOrderTravers(root);
//        System.out.println("\ninOrderTravers");
//        inOrderTravers(root);
    }

    public boolean isBalansed(){
        if (depth(root.left) - depth(root.right) == 0 ||
            depth(root.left) - depth(root.right) == 1 ||
            depth(root.left) - depth(root.right) == -1){
            return true;
        }
        return false;
    }

    private int depth(TreeNode current){
        int countL, countR;
        if (current == null) return 0;
        countL = depth(current.left);
        countR = depth(current.right);
        return 1 + Math.max(countL, countR);
    }

    public void showDepth(){
        System.out.println("Left branch depth: " + depth(root.left));
        System.out.println("Right branch depth: " + depth(root.right));
        System.out.println("Tree depth:" + treeDepth());
    }

    public int treeDepth(){
        return Math.max(depth(root.left), depth(root.right));
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

//    public int depthLeftVal = 0, depthRightVal = 0, depthVal = 0;

            /*
    private boolean hasChildren(TreeNode current){
        if (current.right != null || current.left != null){
            return true;
        }else return false;
    }
     */

    /*
    private void depthLeftBranch(TreeNode current){
        if (current != null){
            if (hasChildren(current)){
                depthLeftVal++;
            }
            depthLeftBranch(current.left);
            depthLeftBranch(current.right);
        }

    }
     */

        /*
    private void depthRightBranch(TreeNode current){
        if (current != null){
            if (hasChildren(current)){
                depthRightVal++;
            }
            depthRightBranch(current.right);
            depthRightBranch(current.left);
        }
    }
     */



}