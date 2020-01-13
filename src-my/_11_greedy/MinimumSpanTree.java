package _11_greedy;

import java.util.*;

public class MinimumSpanTree {

    static class Graph {
        LinkedList<Edge>[] adj;

        Graph(int vertexCount) {
            this.adj = new LinkedList[vertexCount];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int from, int to, int weight) {
            adj[from].add(new Edge(from, to, weight));
            adj[to].add(new Edge(to, from, weight));
        }

        int getWeight(int from, int to) {
            for (int i = 0; i < adj[from].size(); i++) {
                Edge e = adj[from].get(i);
                if (e.to == to) {
                    return e.weight;
                }
            }
            return Integer.MAX_VALUE;
        }

        void printAll() { // 递归打印 s->t 的路径
            for (int i = 0; i < adj.length; i++) {
                System.out.print("vertex:" + i + ", edge: ");
                LinkedList<Edge> edges = adj[i];
                for (Edge edge : edges) {
                    System.out.print(edge.to + "(" + edge.weight + ") ");
                }
                System.out.println();
            }
        }

        void prim() {
            List<Integer> u = new ArrayList<>();
            u.add(0);
            List<Integer> v = new ArrayList<>();
            for (int i = 1; i < adj.length; i++) {
                v.add(i);
            }

            int[] parent = new int[adj.length];
            for (int i = 0; i < adj.length; i++) {
                parent[i] = -1;
            }

            while (u.size() < adj.length) {
                int from = -1, to = -1, weight = Integer.MAX_VALUE;
                for (Integer i : u) {
                    for (Integer j : v) {
                        int w = getWeight(i, j);
                        if (w < weight) {
                            weight = w;
                            from = i;
                            to = j;
                        }

                    }
                }
                u.add(to);
                v.remove(v.indexOf(to));
                parent[to] = from;
            }
            System.out.println(Arrays.toString(parent));
        }

        void kruskal() {
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < adj.length; i++) {
                edges.addAll(adj[i]);
            }
            Collections.sort(edges, (a, b) -> a.weight > b.weight ? 1 : a.weight == b.weight ? 0 : -1);

            int[] parent = new int[adj.length];
            for (int i = 0; i < adj.length; i++) {
                parent[i] = -1;
            }

            for (Edge edge : edges) {
                int m = find(parent, edge.from);
                int n = find(parent, edge.to);
                if (m != n) { //不连通则通过起来
                    parent[m] = n;
                    System.out.println("from=" + edge.from + ",end=" + edge.to);
                }
            }

            System.out.println();
        }

        // 并查集，查找相同父节点
        private static int find(int[] parent, int ch) {
            while (parent[ch] > -1) {
                ch = parent[ch];
            }
            return ch;
        }

    }

    static class Vertex implements Comparable<Vertex> {
        int id;
        int dist;

        Vertex(int id, int distance) {
            this.id = id;
            this.dist = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.dist > o.dist ? 1 : this.dist == o.dist ? 0 : -1;
        }
    }

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);
        graph.printAll();

        // 加点法最小生成树
        graph.prim();

        System.out.println();

        // 加边法最小生成树
        graph.kruskal();
    }

}
