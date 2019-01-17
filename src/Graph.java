import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int counter = -1;
    public static String heuristics = "diagonal";

    private Node startNode;

    private List<Node> openNodes = new ArrayList<>();
    private List<Node> closedNodes = new ArrayList<>();

    public static final int COST = 1;

    private Node minOpenSuccessor() {
        Node min = null;
        Integer minValue = Integer.MAX_VALUE;

        for (Node node : openNodes) {
            if (node.f < minValue) {
                minValue = node.f;
                min = node;
            }
        }

        return min;
    }

    private List<Node> nextNodes(Node last) {
        List<Node> successors = new ArrayList<>();

        if (last.hasUpMove()) {
            Node newSuccessor = new Node(last, COST, last.blankX - 1, last.blankY);
            //newSuccessor.setSuccessorBoard();
            successors.add(newSuccessor);
        }
        if (last.hasDownMove()) {
            Node newSuccessor = new Node(last, COST, last.blankX + 1, last.blankY);
            //newSuccessor.setSuccessorBoard();
            successors.add(newSuccessor);
        }
        if (last.hasLeftMove()) {
            Node newSuccessor = new Node(last, COST, last.blankX, last.blankY - 1);
            //newSuccessor.setSuccessorBoard();
            successors.add(newSuccessor);
        }
        if (last.hasRightMove()) {
            Node newSuccessor = new Node(last, COST, last.blankX, last.blankY + 1);
            //newSuccessor.setSuccessorBoard();
            successors.add(newSuccessor);
        }

        return successors;
    }

    public void solveTheGame(int blankX, int blankY, int[][] startState) {

        long startTime = System.currentTimeMillis();
        long endTime = 0;

        startNode = new Node(null, 0, blankX, blankY);
        startNode.setBoard(startState);
        startNode.countFunctions(COST);

        if (!startNode.checkIfSolvable()) {
            System.out.println("Zadanie jest nierozwiązywalne!");
            return;
        }

        openNodes.add(startNode);

        while (!openNodes.isEmpty()) {
            Node process = minOpenSuccessor();
            counter++;
            System.out.println(counter + ")  " + process);

            if (Node.isGoal(process)) {
                System.out.println("Gotowe! Zadanie rozwiązano w " + counter + " krokach!" + "\n" + process);
                endTime = System.currentTimeMillis() - startTime;
                System.out.println("Czas wykonania: " + endTime + " ms");
                return;
            }

            openNodes.remove(process);
            closedNodes.add(process);
            // openNodes.clear();

            for (Node nextNode : nextNodes(process)) {
                if (closedNodes.contains(nextNode))
                    continue;

                if (!openNodes.contains(nextNode))
                    openNodes.add(nextNode);

                else {
                    System.out.println(process);
                }
            }
        }
        System.out.println("Zadanie jest nierozwiązywalne!");
    }
}
