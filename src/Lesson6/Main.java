package Lesson6;

import Lesson4.Cat;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        int nameNum = 0;
        double unBallanced = 0;
        Tree[] treeArr = new Tree[20];
        for (int i = 0; i < treeArr.length; i++) {
            Tree tree = new Tree("Tree " + i);
            do {
                tree.insert(new Cat(rnd.nextInt(201) - 100, "Barsik" + nameNum++));
            } while (tree.treeDepth() != 6);
            treeArr[i] = tree;
            tree.displayTree();
            System.out.println();
            tree.showDepth();
            System.out.println("Tree isBalansed: " + tree.isBalansed());
            System.out.println();
        }

        for (int i = 0; i < treeArr.length; i++) {
            if (!treeArr[i].isBalansed()) unBallanced++;
        }

        System.out.println("Количество деревьев: " + treeArr.length +
                "\nКоличество несбалансированных деревьев: " + unBallanced +
                "\nПроцент несбалансированных деревьев: " + unBallanced/treeArr.length * 100 + "%");
    }
}
