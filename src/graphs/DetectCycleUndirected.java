package graphs;

import java.util.List;

class DetectCycleUndirected {
    static boolean[] visited;

    static boolean detectCycle(List<List<Integer>> graph) {
        int v = graph.size();
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, -1)) return true;
            }
        }
        return false;
    }

    static boolean dfs(List<List<Integer>> graph, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input();
        boolean cycle = detectCycle(graph);

        if (cycle) {
            System.out.println("Cyclic Undirected Graph");
        } else {
            System.out.println("Acyclic Undirected Graph");
        }
    }
}
