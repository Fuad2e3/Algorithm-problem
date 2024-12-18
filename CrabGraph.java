import java.util.ArrayList;

public class CrabGraph {
    private ArrayList<Integer>[] graph;
    private int[] bodyVertices;
    private int legLimit;

    // Constructor to initialize Crab Graph
    public CrabGraph(int vertices, int legLimit) {
        this.legLimit = legLimit;
        graph = new ArrayList[vertices];
        bodyVertices = new int[vertices];
        
        // Initialize each vertex's adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // Method to add an edge (u -> v) where u is the body and v is a leg
    public void addEdge(int u, int v) {
        // Check leg limit for body vertices
        if (graph[u].size() < legLimit) {
            graph[u].add(v);
            graph[v].add(u);
            bodyVertices[u] = 1;  // Mark vertex u as a body vertex
        } else {
            System.out.println("Leg limit reached for body vertex " + u);
        }
    }

    // Method to print the graph structure
    public void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    // Sample check if vertex is a body vertex
    public boolean isBodyVertex(int u) {
        return bodyVertices[u] == 1;
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices in graph
        int legLimit = 3; // Maximum legs per crab body

        CrabGraph crabGraph = new CrabGraph(vertices, legLimit);

        // Adding edges with body and leg configuration
        crabGraph.addEdge(0, 1);
        crabGraph.addEdge(0, 2);
        crabGraph.addEdge(0, 3);
        crabGraph.addEdge(1, 4);
        crabGraph.addEdge(1, 5);

        // Print the Crab Graph structure
        crabGraph.printGraph();

        // Check if a vertex is a body
        System.out.println("Is vertex 0 a body vertex? " + crabGraph.isBodyVertex(0));
    }
}