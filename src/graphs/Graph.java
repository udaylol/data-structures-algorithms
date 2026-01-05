package graphs;

import java.util.*;

class Graph {
    static class Node {
        String data;
        List<Node> neighbors = new ArrayList<>();

        Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "(" + data + ")";
        }
    }

    private final List<Node> nodes = new ArrayList<>();
    private Set<Node> visited;

    private Graph() {}

    static Graph build(int V, List<String> data, List<int[]> edges) {
        Graph graph = new Graph();

        for (int i = 0; i < V; i++) {
            graph.nodes.add(new Node(data.get(i)));
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Node a = graph.nodes.get(u);
            Node b = graph.nodes.get(v);

            a.neighbors.add(b);
            b.neighbors.add(a);
        }

        return graph;
    }

    static Graph readFromInput(Scanner sc) {
        System.out.print("Number of vertices: ");
        int V = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter " + V + " data entries: ");
        List<String> data = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            System.out.print("data " + i + ": ");
            data.add(sc.nextLine());
        }

        System.out.print("Number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter " + E + " edges: ");
        List<int[]> edges = new ArrayList<>(E);
        for (int i = 0; i < E; i++) {
            System.out.print("edge " + i + ": ");
            edges.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        return build(V, data, edges);
    }

    void print() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(i + " : " + nodes.get(i) +  " is connected to " + nodes.get(i).neighbors);
        }
        System.out.println();
    }

    void dfs() {
        visited = new HashSet<>();
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                dfs(node);
            }
        }
    }

    private void dfs(Node curr) {
        System.out.println(curr);
        visited.add(curr);

        for (Node neighbor : curr.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    void bfs() {
        visited = new HashSet<>();
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                bfs(node);
            }
        }
    }

    private void bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            System.out.println(curr);

            for (Node neighbor : curr.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
    }
}
