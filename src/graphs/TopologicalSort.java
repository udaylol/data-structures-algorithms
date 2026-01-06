package graphs;

import java.util.*;

public class TopologicalSort {
    static boolean[] visited;

    static List<Integer> topologicalSort(List<List<Integer>> graph) {
        int v = graph.size();
        visited = new boolean[v];
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(graph, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    static void dfs(List<List<Integer>> graph, int node, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, stack);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input(true);
        List<Integer> list = topologicalSort(graph);
        System.out.println(list);
    }
}
