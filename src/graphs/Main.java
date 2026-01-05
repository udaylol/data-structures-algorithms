package graphs;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Graph graph = Graph.readFromInput(sc);

        graph.print();

        System.out.println("\nDFS:");
        graph.dfs();

        System.out.println("\nBFS:");
        graph.bfs();
    }
}
