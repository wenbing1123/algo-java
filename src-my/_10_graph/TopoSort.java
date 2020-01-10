package _10_graph;

import _04_queue.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TopoSort {

    // 有向无权图
    static class Graph {
        LinkedList<Integer>[] adj;
        int v;

        Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int from, int to) {
            adj[from].add(to);
        }

        void printAll() { // 递归打印 s->t 的路径
            for (int i = 0; i < adj.length; i++) {
                System.out.print("vertex:" + i + ", edge: ");
                LinkedList<Integer> edges = adj[i];
                for (int edge : edges) {
                    System.out.print(edge+" ");
                }
                System.out.println();
            }
        }

        void topoSortByKahn() {
            int[] inDegree = new int[v];
            for (int i = 0; i < v; i++) {
                for(int j=0; j< adj[i].size(); j++) {
                    inDegree[adj[i].get(j)]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int i = queue.remove();
                System.out.print("->" + i);
                for (int j=0; j< adj[i].size(); j++) {
                    int k = adj[i].get(j);
                    inDegree[k]--;
                    if(inDegree[k]==0) queue.add(k);
                }
            }

            System.out.println();
        }

        void topoSortByDFS() {
            LinkedList<Integer>[] inverseAdj = new LinkedList[v];
            for (int i = 0; i < inverseAdj.length; i++) {
                inverseAdj[i] = new LinkedList<>();
            }

            for (int i = 0; i < v; i++) {
                for (int j=0; j< adj[i].size(); j++) {
                    int w = adj[i].get(j);
                    inverseAdj[w].add(i);
                }
            }

            boolean[] visited = new boolean[v];
            for (int i=0; i<v; i++) {
                if (visited[i] != true) {
                    visited[i] = true;
                    dfs(i, inverseAdj, visited);
                }
            }

            System.out.println();
        }

        void dfs(int i, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
            for (int j = 0; j < inverseAdj[i].size(); j++) {
                if (visited[j] != true) {
                    visited[j] = true;
                    dfs(j, inverseAdj, visited);
                }
            }
            System.out.print("->" + i);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
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

        graph.topoSortByKahn();

        graph.topoSortByDFS();
    }
}
