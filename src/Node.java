import java.util.ArrayList;
import java.util.List;

public class Node {

    public int blankX, blankY;
    public Node parent;
    public int g, h, f;
    public int[][] board;

    public static int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    public Node(Node parent, int cost, int blankX, int blankY) {
        this.blankX = blankX;
        this.blankY = blankY;
        this.parent = parent;
        this.board = new int[3][3];
        this.setSuccessorBoard();
        if (parent == null) {}
        else{
        h = countHeuristics();
        g += parent.g + cost;
        f = h + g;}
    }

    public void countFunctions(int cost) {
        h = countHeuristics();
        if (parent == null)
            g = 0;
        else
        g += parent.g + cost;

        f = h + g;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int countHeuristics() {
        int result = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {}
                else {
                    if (board[i][j] != goal[i][j]) {
                        for (int k = 0; k < goal[0].length; k++) {
                            for (int l = 0; l < goal[0].length; l++) {
                                if (board[i][j] == goal[k][l]) {
                                    result += Math.abs(i - k) + Math.abs(j - l);
                                }
                            }
                        }
                    }
                }
            }
        }
        return  result;
    }

    public static boolean isGoal(Node node) {
        boolean result = (node.board == goal || node.h == 0 ? true : false);
        return  result;
    }

    public boolean hasUpMove() {
        boolean answer = (blankX - 1 >= 0 ? true : false);
        return  answer;
    }

    public  boolean hasDownMove() {
        boolean answer = (blankX + 1 < board[0].length ? true : false);
        return answer;
    }

    public  boolean hasLeftMove() {
        boolean answer = (blankY - 1 >= 0 ? true : false);
        return answer;
    }

    public boolean hasRightMove() {
        boolean answer = (blankY + 1 < board[0].length ? true : false);
        return  answer;
    }

    public void setSuccessorBoard() {
        if (parent == null) {}
        else {

            for (int i = 0; i < parent.board[0].length; i++) {
                for (int j = 0; j < parent.board[0].length; j++) {
                    this.board[i][j] = parent.board[i][j];
                }
            }
                        this.board[parent.blankX][parent.blankY]  = this.board[blankX][blankY];
                        this.board[blankX][blankY] = 0;
            }
        }

        private  int getOneDimensionValuesArrayElement(int index) {
        int result;

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < board[0].length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    list.add(board[i][j]);
                }
            }

            return list.get(index);
        }

    private int countInversions() {
        int inv_count = 0;
        for (int i = 0; i < this.board[0].length * this.board[0].length - 1; i++) {
            for (int j = i + 1; j < this.board[0].length * this.board[0].length; j++) {
                if (this.getOneDimensionValuesArrayElement(i) != 0 && this.getOneDimensionValuesArrayElement(j) != 0 && this.getOneDimensionValuesArrayElement(i) > this.getOneDimensionValuesArrayElement(j)) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    public boolean checkIfSolvable() {
        // firts condition: if width is odd then puzzle instance is solvable if number of inversions is even
        if (this.board[0].length % 2 != 0) {if (this.countInversions() % 2 == 0) {return  true;}
        else {return false;}}
        /* second condition: if width is even, puzzle instance is solvable if:
            - the blank is on an even row counting from the bottom (second-last, fourth-last, etc.) and number of inversions is odd.
            - the blank is on an odd row counting from the bottom (last, third-last, fifth-last, etc.) and number of inversions is even.
         */
        else if (this.board[0].length % 2 == 0) {
            if (((this.board[0].length - this.board[0].length) % 2 == 0) && (this.countInversions() % 2 != 0)) {
                return true;
            } else if (((this.board[0].length - this.board[0].length) % 2 != 0) && (this.countInversions() % 2 == 0)) {
                return true;
            }
        }
        else {return false;}
        return false;

    }

    @Override
    public String toString() {
        return "G: " + g + ", H: " + h + ", F: " + f + "\n"
                + "| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |\n"
                + "| " + board[1][0] + " " + board[1][1]  + " " + board[1][2] + " |\n"
                + "| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n";
    }
}
