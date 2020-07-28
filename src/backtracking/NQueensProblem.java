package backtracking;

import java.util.Arrays;

public class NQueensProblem {
    public static void main(String[] args) {

        Board board = new Board(16);
        board.solve();
    }

    private static class Board {
        Board(int N) {
            this.N = N;
            this.board = new int[N][N];
        }

        private final int N;
        private final int[][] board;


        private void solve() {
            if (canPlaceOnBoard(0)) printBoard();
            else System.out.println("Cant be placed");
        }

        private void printBoard() {
            for (int [] cols : board)
                System.out.println(Arrays.toString(cols));
        }

        private boolean canPlaceOnBoard(int col) {
            if (col == N) return true;

            for (int row = 0; row < N; row++) {
                if (isValidPlacement(row, col)) {
                    board[row][col] = 1;
                    if (canPlaceOnBoard(col + 1)) return true;
                }
                board[row][col] = 0;
            }
            return false;
        }

        private boolean isValidPlacement(int row, int col) {
            int j = col;
            while (j > -1)
                if (board[row][j--] == 1) return false;

            int i = row;
            j = col;
            while (j > -1 && i > -1)
                if (board[i--][j--] == 1) return false;

            i = row;
            j = col;
            while (j > -1 && i < N)
                if (board[i++][j--] == 1) return false;

            return true;
        }


    }
}
