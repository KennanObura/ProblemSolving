package TutorialHorizon;

import java.text.DecimalFormat;

/**
 * A knight’s tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only once.
 * If the knight ends on a square that is one knight’s move from the beginning square (so that it could tour the board again
 * immediately, following the same path), the tour is closed, otherwise it is open. (Source : http://en.wikipedia.org/wiki/Knight%27s_tour)
 */
public class KnightMoveProblem {
    public static void main(String[] args) {

        KnightPath knightPath = new KnightPath(8);
        knightPath.findPath();

    }
}

class KnightPath {
    int path = 0;
    int[][] solution;
    int length;

    KnightPath(int length) {
        this.length = length;
        solution = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                solution[i][j] = 0;
            }
        }
    }

    void findPath() {
        boolean isPath = findPath(solution, 0, 0, 0);
        if(isPath) print();
        else System.out.println("NO path");
    }

    private boolean findPath(int[][] solution, int row, int col, int index) {
        if (path == length * length - 1) return true;

        if (solution[row][col] != 0) return false;

        solution[row][col] = path++;



        //go down and left
        if(canMove(length, row-1, col+2) && findPath(solution, row-1, col+2, index+1))
            return true;

        //go down and right
        if(canMove(length, row+1, col+2) && findPath(solution, row+1, col+2, index+1))
            return true;

        // go right and down
        if(canMove(length, row+2, col+1) && findPath(solution, row+2, col+1, index+1))
            return true;

        //go right and up
        if(canMove(length, row+2, col-1) && findPath(solution, row+2, col-1, index+1))
            return true;

        //go left and up
        if(canMove(length, row-2, col-1) && findPath(solution, row-2, col-1, index+1))
            return true;

        //go left and down
        if(canMove(length, row-2, col+1) && findPath(solution, row-2, col+1, index+1))
            return true;


        //go down and left
        if(canMove(length, row-1, col-2) && findPath(solution, row-1, col-2, index+1))
            return true;

        //go down and right
        if(canMove(length, row+1, col-2) && findPath(solution, row+1, col-2, index+1))
            return true;

        /**
         * If we are here. Means possible no path. Backtrack
         */
        solution[row][col] = 0;
        path--;
        return false;
    }

    private boolean canMove(int length, int row, int col) {
        return (row > -1 && row < length && col > -1 && col < length);
    }

    public void print() {
        DecimalFormat twodigits = new DecimalFormat("00");
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print("   " + twodigits.format(solution[i][j]));
            }
            System.out.println();
        }
    }
}
