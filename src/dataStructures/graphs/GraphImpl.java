package src.dataStructures.graphs;

public class GraphImpl {

    public static void main(String[] args) {

        Graph graph = new Graph(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        System.out.println("---After adding vertex---");
        graph.printGraphList();

        graph.removeVertex("B");

        System.out.println("---After removing vertex---");
        graph.printGraphList();

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        graph.addEdge("A", "C");
        graph.addEdge("A", "E");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");

        System.out.println("---After adding edges---");
        graph.printGraphList();

        graph.removeEdges("A", "E");

        System.out.println("---After removing edges---");
        graph.printGraphList();

    }
}
