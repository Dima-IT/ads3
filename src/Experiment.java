public class Experiment {

    public void runTraversals(Graph g) {
        g.bfs(0);
        g.dfs(0);
    }

    public void runMultipleTests() {
        testGraph(10);
        testGraph(30);
        testGraph(100);
    }

    private void testGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        for (int i = 0; i < size - 2; i += 2) {
            graph.addEdge(i, i + 2);
        }

        System.out.println("\nGraph size: " + size + " vertices");

        long startBfs = System.nanoTime();
        graph.bfs(0);
        long endBfs = System.nanoTime();

        long bfsTime = endBfs - startBfs;

        long startDfs = System.nanoTime();
        graph.dfs(0);
        long endDfs = System.nanoTime();

        long dfsTime = endDfs - startDfs;

        System.out.println("BFS time: " + bfsTime + " ns");
        System.out.println("DFS time: " + dfsTime + " ns");
    }

    public void printResults() {
        System.out.println("Experiments completed.");
    }
}