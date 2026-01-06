package graphs;

import java.util.*;

class BFS {
    static boolean[] visited;

    static void traverse(List<List<Integer>> graph) {
        int v = graph.size();
        int components = 0;
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                components++;
                System.out.print("\nconnected component: ");
                bfs(graph, i, visited);
            }
        }
        System.out.println("\nSuccessfully traversed graph with " + components + " components");
    }

    static void bfs(List<List<Integer>> graph, int node, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            System.out.print(curr + " ");
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input();
        traverse(graph);
    }
}
