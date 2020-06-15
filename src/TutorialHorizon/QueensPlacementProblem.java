package TutorialHorizon;

import java.text.DecimalFormat;

/**
 * N - Queens problem is to place n - queens in such a manner on an n x n
 * chessboard that no queens attack each other by being in the same row, column or diagonal.
 */
public class QueensPlacementProblem {
    public static void main(String[] args) {

        Board board = new Board(4);
        board.place();
    }

    private static class Board {
        private final int[][] board;
        private final int N;


        Board(int N) {
            this.N = N;
            board = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    board[i][j] = 0;
        }

        void place() {
            if (placed(board, 0)) print();
            else    System.out.print("Not successful");
        }

        private void print(){
//            DecimalFormat myformat = new DecimalFormat("00");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(" " +(board[i][j]));
                System.out.println("");
            }
        }

        private boolean placed(int[][] board, int col) {
            if (col == N) return true;

            for (int i = 0; i < N; i++) {
//                System.out.print("" + i);
                if (canPlace(i, col)) {
                    board[i][col] = 1;
                    if (placed(board, col + 1)) return true;
                }
                board[i][col] = 0;
            }
            return false;
        }

        private boolean canPlace(int row, int col) {
            //look this column to left
            int i = col;
            while (i > -1)
                if (board[row][i--] == 1) return false;
            //look from here to top left
            int j = col;
            i = row;
            while (i > -1 && j > -1)
                if (board[i--][j--] == 1) return false;

            j = col;
            i = row;
            while (i > -1 && j < N)
                if (board[i--][j++] == 1) return false;

            return true;
        }
    }
}
