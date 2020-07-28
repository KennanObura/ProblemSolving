package GeekforGeeks.TopBacktracking;

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {

        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        Board board = new Board(grid);
        board.solve();

    }

    private static class Board {
        int[][] board;
        int MAX;

        Board(int[][] board) {
            this.board = board;
            this.MAX = board.length;
        }



        private void solve() {
            if (fullyPlaced()) printBoard();
            else System.out.println("NOT ABLE TO SOLVE");
        }


        //Time complexity 9^n*n , for every unasigned , there are 9 possible placements
        private boolean fullyPlaced() {
            for (int row = 0; row < MAX; row++) {
                for (int col = 0; col < MAX; col++) {
                    if (board[row][col] != 0) continue;

                    for (int num = 1; num <= MAX; num++) {

                        if (isValidPlacement(row, col, num)) {
                            board[row][col] = num;
                            if (fullyPlaced()) return true;
                        }
                        board[row][col] = 0;
                    }
                    return false;
                }
            }
            return true;
        }




        private boolean isValidPlacement(int row, int col, int num) {
            return boxValid(row, col, num) && rowValid(col, num) && colValid(row, num);
        }

        private boolean colValid(int row, int num) {
            int col = 0;
            while (col < MAX)
                if (board[row][col++] == num) return false;
            return true;
        }

        private boolean rowValid(int col, int num) {
            int row = 0;
            while (row < MAX)
                if (board[row++][col] == num) return false;
            return true;
        }

        private boolean boxValid(int row, int col, int num) {
            int squareRoot = (int) Math.sqrt(MAX);
            int boxStartRow = row - row % squareRoot;
            int boxStartCol = col - col % squareRoot;

            for (int i = boxStartRow; i < boxStartRow + squareRoot; i++)
                for (int j = boxStartCol; j < boxStartCol + squareRoot; j++)
                    if (board[i][j] == num) return false;
            return true;
        }

        private void printBoard() {
            for (int[] column : board)
                System.out.println(Arrays.toString(column));
        }
    }
}
