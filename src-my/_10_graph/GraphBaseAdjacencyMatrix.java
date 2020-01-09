package _10_graph;

import java.util.ArrayList;

public class GraphBaseAdjacencyMatrix<E> {

    private ArrayList<E> vertexes;
    private int[][] edges;
    private int edgeCount;

    public GraphBaseAdjacencyMatrix(int vertexCount) {
        this.vertexes = new ArrayList<>(vertexCount);
        this.edges = new int[vertexCount][vertexCount];
        this.edgeCount = 0;
    }

    public static void main(String[] args) {

    }

}
