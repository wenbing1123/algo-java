package _10_graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Graph {
        int v;
        LinkedList<Edge>[] adj;

        Graph(int vertexCount) {
            this.v = vertexCount;
            this.adj = new LinkedList[vertexCount];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int from, int to, int weight) {
            adj[from].add(new Edge(from, to, weight));
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

        // 最短路径
        void dijkstra(int s, int t) {
            int[] predecessor = new int[v];
            for (int i = 0; i < predecessor.length; i++) {
                predecessor[i] = -1;
            }

            boolean[] visited = new boolean[v];
            Vertex[] vertices = new Vertex[v];
            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = new Vertex(i, Integer.MAX_VALUE);
            }
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            vertices[s].distance = 0;
            queue.add(vertices[s]);
            visited[s] = true;
            while (!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                if (vertex.id == t) break; //找到了一条路径
                for (int i = 0; i < adj[vertex.id].size(); i++) {
                    Edge edge = adj[vertex.id].get(i);
                    Vertex nextVertex = vertices[edge.to];
                    if (vertex.distance + edge.weight < nextVertex.distance) {
                        nextVertex.distance = vertex.distance + edge.weight;
                        predecessor[nextVertex.id] = vertex.id;
                        if (!visited[nextVertex.id]) {
                            queue.add(nextVertex);
                            visited[nextVertex.id] = true;
                        }
                    }
                }
            }

            System.out.print(s);
            print(s, t, predecessor);
            System.out.println();
        }

        private void print(int s, int t, int[] predecessor) {
            if (s == t) return;
            print(s, predecessor[t], predecessor);
            System.out.print("->" + t);
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int id;
        int distance;

        Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance > o.distance ? 1 : this.distance == o.distance ? 0 : -1;
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
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1,10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        graph.printAll();

        graph.dijkstra(0, 5);
    }
}
