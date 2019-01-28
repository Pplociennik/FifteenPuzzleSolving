import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifteenPuzzleSolving {

    private int[][] grid;
    private String heuristics = "manhattan";

    private int x, y;

    public void startProgram() {

        Graph graph = new Graph();
        Graph.heuristics = heuristics;
        userInterface();
        graph.solveTheGame(x, y, grid);
    }

    public void userInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj!\nWYBIERZ HEURYSTYKE [manhattan/diagonal]");

        heuristics = scanner.nextLine();

        System.out.println("Wybierz rodzaj gry [8/15]");

        Node.arrayLength = scanner.nextInt() + 1;

        grid = new int[(int) Math.sqrt(Node.arrayLength)][(int) Math.sqrt(Node.arrayLength)];

        System.out.println("Wpisz kolejno liczby Twojej macierzy (0 - pusta kratka)");
        int list[] = new int[Node.arrayLength];

        for (int i = 0; i < Node.arrayLength; i++) {
            list[i] = scanner.nextInt();
        }
        findBlank(list);


    }

    public void findBlank(int[] numbers) {
        int counter = -1;
        for (int i = 0; i < Math.sqrt(Node.arrayLength); i++) {
            for (int j = 0; j < Math.sqrt(Node.arrayLength); j++) {
                counter++;
                if (numbers[counter] == 0) {
                    this.x = i;
                    this.y = j;
                } else {
                    this.grid[i][j] = numbers[counter];
                }
            }
        }
    }


}
