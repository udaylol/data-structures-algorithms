package graphs;

import java.util.*;

public class Graph {

    private static List<List<Integer>> build(int v, List<int[]> edges, boolean isDirected) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (a < 0 || b < 0 || a >= v || b >= v) {
                throw new IllegalArgumentException(
                        "Invalid edge: (" + a + ", " + b + ") for V = " + v
                );
            }

            graph.get(a).add(b);
            if (!isDirected) {
                graph.get(b).add(a);
            }
        }

        return graph;
    }

    static List<List<Integer>> input() {
        return input(false);
    }

    static List<List<Integer>> input(boolean isDirected) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Number of edges: ");
        int e = sc.nextInt();
        sc.nextLine();

        List<int[]> edges = new ArrayList<>(e);
        for (int i = 0; i < e; i++) {
            System.out.print("edge " + i + ": ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges.add(new int[]{a, b});
        }

        return build(v, edges, isDirected);
    }
}
