package graphs;

import java.util.*;

class Graph {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + to + ", w=" + weight + ")";
        }
    }

    private static List<List<Integer>> build(int v, List<int[]> edges, boolean isDirected) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if (a < 0 || b < 0 || a >= v || b >= v) {
                throw new IllegalArgumentException("Invalid edge: (" + a + ", " + b + ") for V = " + v);
            }

            graph.get(a).add(b);
            if (!isDirected) {
                graph.get(b).add(a);
            }
        }

        return graph;
    }

    private static List<List<Edge>> buildWeighted(int v, List<int[]> edges, boolean isDirected) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];

            if (a < 0 || b < 0 || a >= v || b >= v) {
                throw new IllegalArgumentException("Invalid edge: (" + a + ", " + b + ") for V = " + v);
            }

            graph.get(a).add(new Edge(b, weight));
            if (!isDirected) {
                graph.get(b).add(new Edge(a, weight));
            }
        }

        return graph;
    }

    static List<List<Integer>> input() {
        return input(false);
    }

    static List<List<Integer>> inputDirected() {
        return input(true);
    }

    private static List<List<Integer>> input(boolean isDirected) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Number of edges: ");
        int e = sc.nextInt();

        List<int[]> edges = new ArrayList<>(e);
        for (int i = 0; i < e; i++) {
            System.out.print("edge " + i + " (a b): ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges.add(new int[]{a, b});
        }

        return build(v, edges, isDirected);
    }

    static List<List<Edge>> inputWeighted() {
        return inputWeighted(false);
    }

    static List<List<Edge>> inputDirectedWeighted() {
        return inputWeighted(true);
    }

    private static List<List<Edge>> inputWeighted(boolean isDirected) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Number of edges: ");
        int e = sc.nextInt();

        List<int[]> edges = new ArrayList<>(e);
        for (int i = 0; i < e; i++) {
            System.out.print("edge " + i + " (a b w): ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new int[]{a, b, w});
        }

        return buildWeighted(v, edges, isDirected);
    }
}
