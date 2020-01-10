package _10_graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphBaseAdjacencyMatrix<E> {

    private ArrayList<E> vertexes;
    private int[][] edges;
    private int edgeCount;
    private boolean digraph = false;

    public GraphBaseAdjacencyMatrix(int vertexCount) {
        this.vertexes = new ArrayList<>(vertexCount);
        this.edges = new int[vertexCount][vertexCount];
        this.edgeCount = 0;
    }

    public GraphBaseAdjacencyMatrix(int vertexCount, boolean digraph) {
        this(vertexCount);
        this.digraph = digraph;
    }

    public void addVertex(E vertex) {
        vertexes.add(vertex);
    }

    public void addEdge(int from, int to, int weight) {
        edges[from][to] = weight;
        if(!digraph) {
            edges[to][from] = weight;
        }
        edgeCount++;
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void removeEdge(int from, int to) {
        edges[from][to] = 0;
        if(!digraph) {
            edges[to][from] = 0;
        }
        edgeCount--;
    }

    public E getVertex(int i) {
        return vertexes.get(i);
    }

    public int getWeight(int from, int to) {
        return edges[from][to];
    }

    public int getVertexCount() {
        return vertexes.size();
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public int[] getNeighbor(int i) {
        ArrayList<Integer> list = new ArrayList<>(vertexes.size());
        for (int j = 0; j < vertexes.size(); j++) {
             if (edges[i][j] > 0) {
                 list.add(j);
             }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int n=4,e=4; //分别代表结点个数和边的数目
        String labels[]={"V1","V1","V3","V4"}; //结点的标识
        var graph = new GraphBaseAdjacencyMatrix<String>(n, true);
        for(String label:labels) {
            graph.addVertex(label); //插入结点
        }

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 0, 7);

        System.out.println("结点个数是："+graph.getVertexCount());
        System.out.println("边的个数是："+graph.getEdgeCount());
        System.out.println("v1的邻边："+ Arrays.toString(graph.getNeighbor(0)));
        System.out.println("v4的邻边："+ Arrays.toString(graph.getNeighbor(3)));

        graph.removeEdge(0, 1);//删除<V1,V2>边
        System.out.println("删除<V1,V2>边后...");
        System.out.println("结点个数是："+graph.getVertexCount());
        System.out.println("边的个数是："+graph.getEdgeCount());
        System.out.println("v1的邻边："+ Arrays.toString(graph.getNeighbor(0)));
        System.out.println("v4的邻边："+ Arrays.toString(graph.getNeighbor(3)));
    }

}
