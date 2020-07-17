package Lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('i');
        graph.addVertex('j');

        graph.addEdge(0, 1);
        graph.addEdge(1, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(5, 2);
        graph.addEdge(3, 7);
        graph.addEdge(7, 9);
        graph.addEdge(5, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 6);

        graph.widthTraverse(0, 9);
    }
}
