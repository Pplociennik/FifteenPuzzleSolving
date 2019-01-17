import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifteenPuzzleSolving {

    private int[][] grid = new int[3][3];
    private String heuristics = "manhattan";

    private  int x, y;

    public void startProgram() {

        Graph graph = new Graph();
        Graph.heuristics = heuristics;
        userInterface();
        graph.solveTheGame(x, y, grid);
    }

    public void userInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj!\nWYBIERZ HEURYSTYKE {manhattan/diagonal]");

        heuristics = scanner.nextLine();

        System.out.println("Wpisz kolejno liczby Twojej macierzy (0 - pusta kratka)");
        int list[] = new int[9];

        for (int i = 0; i < 9; i++) {
        list[i] = scanner.nextInt();
}
        findBlank(list);


    }

    public void findBlank(int[] numbers) {
        int counter = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                counter++;
                if (numbers[counter] == 0) {
                    this.x = i;
                    this.y = j;
                }
                else {
                    this.grid[i][j] = numbers[counter];
                }
            }
        }
    }


}
