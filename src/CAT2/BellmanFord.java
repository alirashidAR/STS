package CAT2;
import java.util.Arrays;

class Edge {
    int source, destination, weight;
    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFord {
    private int vertices;
    private Edge[] edges;

    BellmanFord(int vertices, Edge[] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void bellmanFord(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print the distances
        printDistances(distance, source);
    }

    private void printDistances(int[] distance, int source) {
        System.out.println("Vertex distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " -> " + (distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = {
                new Edge(0, 1, 6),
                new Edge(0, 2, 7),
                new Edge(1, 2, 8),
                new Edge(1, 3, 5),
                new Edge(1, 4, -4),
                new Edge(2, 3, -3),
                new Edge(2, 4, 9),
                new Edge(3, 1, -2),
                new Edge(4, 0, 2),
                new Edge(4, 3, 7)
        };

        BellmanFord graph = new BellmanFord(vertices, edges);
        graph.bellmanFord(0); // Source vertex is 0
    }
}
