package graphs;

import java.util.*;

public class ShortestPathDAG {

    static int[] shortestPath(List<List<Edge>> graph, int src) {
        int V = graph.size();

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int a = stack.pop();

            if (dist[a] == (int) 1e9) continue;

            for (Edge e2 : graph.get(a)) {
                int b = e2.to;
                int wt = e2.weight;
                dist[b] = Math.min(dist[b], dist[a] + wt);
            }
        }

        return dist;
    }

    static void dfs(List<List<Edge>> graph, int node, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;
        for (Edge edge : graph.get(node)) {
            if (!visited[edge.to]) {
                dfs(graph, edge.to, visited, stack);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        List<List<Edge>> graph = Graph.inputDirectedWeighted();
        int src = 0;

        int[] dist = shortestPath(graph, src);

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] >= (int) 1e9) {
                System.out.println(i + " : unreachable");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }
    }
}
