public class FifteenPuzzleSolving {

    public static void main(String args[]) {

        Graph graph = new Graph();
        int[][] start = {{1, 8, 2}, {0, 4, 3}, {7, 6, 5}};
        graph.solveTheGame(1, 0, start);

    }
}
