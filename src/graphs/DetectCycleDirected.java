package graphs;

import java.util.List;

class DetectCycleDirected {
    static boolean[] visited;
    static boolean[] pathVisited;

    static boolean detectCycle(List<List<Integer>> graph) {
        int v = graph.size();
        visited = new boolean[v];
        pathVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(graph, i)) return true;
            }
        }
        return false;
    }

    static boolean dfs(List<List<Integer>> graph, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor)) return true;
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.inputDirected();
        boolean cycle = detectCycle(graph);

        if (cycle) {
            System.out.println("Cyclic Directed Graph");
        } else {
            System.out.println("Acyclic Directed Graph");
        }
    }
}