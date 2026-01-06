package graphs;

import java.util.*;

class DFS {
    static boolean[] visited;

    static void traverse(List<List<Integer>> graph) {
        int v = graph.size();
        int components = 0;
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                components++;
                System.out.print("\nconnected component: ");
                dfs(graph, i, visited);
            }
        }
        System.out.println("\nSuccessfully traversed graph with " + components + " components");
    }

    static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int neighbor: graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input();
        traverse(graph);
    }
}
