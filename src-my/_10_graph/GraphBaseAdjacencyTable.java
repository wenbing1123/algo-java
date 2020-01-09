package _10_graph;

import java.util.LinkedList;

public class GraphBaseAdjacencyTable<E> {

    private LinkedList<E>[] table;

    public GraphBaseAdjacencyTable(int vertexCount) {
        this.table = new LinkedList[vertexCount];
    }

    public static void main(String[] args) {

    }

}
