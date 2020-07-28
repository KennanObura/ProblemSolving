package GeekforGeeks.TopBacktracking;

import java.text.DecimalFormat;
import java.util.Arrays;

public class KnightTourProblem {

    public static void main(String[] args) {

        Board board = new Board(8);
        board.movement();

    }

    private static class Board {
        Board(int length) {
            this.length = length;
            this.board = new int[length][length];
        }

        private final int length;
        private final int[][] board;
        private int path = 0;

        void movement() {
            if (movement(0, 0)) printBoard();
            else System.out.println("No valid movement");
        }

        private boolean movement(int row, int col) {
            if (path == length * length ) return true;

            board[row][col] = path++;

            if (canSafelyMove(row - 1, col + 2) && movement(row - 1, col + 2)) return true;

            if (canSafelyMove(row + 1, col + 2) && movement(row + 1, col + 2)) return true;

            if (canSafelyMove(row + 2, col + 1) && movement(row + 2, col + 1)) return true;

            if (canSafelyMove(row + 2, col - 1) && movement(row + 2, col - 1)) return true;

            if (canSafelyMove(row - 2, col + 1) && movement(row - 2, col + 1)) return true;

            if (canSafelyMove(row - 2, col - 1) && movement(row - 2, col - 1)) return true;

            if (canSafelyMove(row + 1, col - 2) && movement(row + 1, col - 2)) return true;

            if (canSafelyMove(row - 1, col - 2) && movement(row - 1, col - 2)) return true;

            board[row][col] = 0;
            path--;
            return false;
        }

        private boolean canSafelyMove(int row, int col) {
            return (row > -1 && col > -1 && row < length && col < length && board[row][col] == 0);
        }

        private void printBoard() {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            for (int[] column : board) {
                for (int i : column)
                    System.out.print("  " +decimalFormat.format(i));
                System.out.println();
            }
        }
    }
}
