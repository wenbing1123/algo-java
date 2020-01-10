package _10_graph;

import _04_queue.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphBaseAdjacencyTable {

    private LinkedList<Edge>[] table;
    private boolean digraph;

    public static class Vertex {

    }

    public static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public GraphBaseAdjacencyTable(int vertexCount) {
        this(vertexCount, false);
    }

    public GraphBaseAdjacencyTable(int vertexCount, boolean digraph) {
        this.table = new LinkedList[vertexCount];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        this.digraph = digraph;
    }

    public void addEdge(int from, int to, int weight) {
        table[from].add(new Edge(from, to, weight));
        if (!digraph) {
            table[to].add(new Edge(to, from, weight));
        }
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[table.length];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[table.length];
        for (int i = 0; i < table.length; ++i) {
            prev[i] = -1;
        }
        while (queue.size() > 0) {
            int n = queue.poll();
            for (int i=0; i<table[n].size(); i++) {
                Edge e = table[n].get(i);
                if (!visited[e.to]) {
                    prev[e.to] = n;

                    // 找到了节点
                    if (e.to == t) {
                        print(prev, s, t);
                        return;
                    }

                    visited[e.to] = true;
                    queue.add(e.to);
                }
            }
        }
    }

    public void dfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[table.length];
        visited[s] = true;
        int[] prev = new int[table.length];
        for (int i = 0; i < table.length; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private boolean found = false;
    private void recurDfs(int n, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[n] = true;
        if(n == t) {
            found = true;
            return;
        }
        for(int i=0; i<table[n].size(); i++) {
            Edge e = table[n].get(i);
            if (!visited[e.to]) {
                prev[e.to] = n;
                recurDfs(e.to, t, visited, prev);
            }
        }
    }

    private void printAll() { // 递归打印 s->t 的路径
        for (int i = 0; i < table.length; i++) {
            System.out.print("vertex:" + i + ", edge: ");
            LinkedList<Edge> edges = table[i];
            for (Edge edge : edges) {
                System.out.print(edge.to+" ");
            }
            System.out.println();
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        GraphBaseAdjacencyTable graph = new GraphBaseAdjacencyTable(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.printAll();

        graph.bfs(0, 7);
        System.out.println();
        graph.dfs(0, 7);
    }

}
