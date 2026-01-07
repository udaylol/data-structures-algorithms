package graphs;

import java.util.*;

class TopologicalSort {
    static boolean[] visited;

    static List<Integer> topologicalSortDFS(List<List<Integer>> graph) {
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

    static List<Integer> topologicalSortBFS(List<List<Integer>> graph) {
        int v = graph.size();
        int[] indegree = new int[v];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.remove();
            ans.add(node);

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (ans.size() != v) {
            throw new IllegalStateException("Graph has a cycle. Topological sort not possible.");
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.inputDirected();
        List<Integer> listDFS = topologicalSortDFS(graph);
        List<Integer> listBFS = topologicalSortBFS(graph);
        System.out.println(listDFS);
        System.out.println(listBFS);
    }
}
