package graphs;

import java.util.*;

public class ShortestPathUnweighted {

    static int[] shortestPath(List<List<Integer>> graph, int src) {
        int v = graph.size();
        int[] distance = new int[v];
        Arrays.fill(distance, (int)1e9);

        Queue<Integer> queue = new ArrayDeque<>();
        distance[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int nb : graph.get(curr)) {
                if (distance[nb] == (int)1e9) {
                    distance[nb] = distance[curr] + 1;
                    queue.add(nb);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = Graph.input();
        int src = 0;
        System.out.println(Arrays.toString(shortestPath(graph, src)));
    }
}
