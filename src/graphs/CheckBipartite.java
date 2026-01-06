package graphs;

import java.util.*;

public class CheckBipartite {
    static Boolean[] colors;

    static boolean checkBipartite(List<List<Integer>> graph) {
        int v = graph.size();
        colors = new Boolean[v];
        for (int i = 0; i < v; i++) {
            if (colors[i] == null) {
                if (!dfs(graph, i, true)) return false;
            }
        }
        return true;
    }

    static boolean dfs(List<List<Integer>> graph, int node, boolean color) {
        colors[node] = color;

        for (int neighbor : graph.get(node)) {
            if (colors[neighbor] == null) {
                if (!dfs(graph, neighbor, !color)) return false;
            } else if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input();
        boolean isBipartite = checkBipartite(graph);

        if (isBipartite) {
            System.out.println("Bipartite Graph");
        } else {
            System.out.println("Non Bipartite Graph");
        }
    }
}
