package backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        Sudoku sudoku = new Sudoku(grid);
        sudoku.solve();

    }

    private static class Sudoku {
        int[][] grid;
        int length;

        Sudoku(int[][] grid) {
            this.grid = grid;
            this.length = grid.length;
        }

        void solve() {
            if (isBoardFullyPlaced()) printSolution();
            else System.out.println("Not able to solve");
        }

        private boolean isBoardFullyPlaced() {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {

                    if (grid[i][j] == 0) {
                        System.out.println("Trying row" + i + " & col " + j);
                        for (int k = 1; k <= 9; k++) {
                            if (isValid(i, j, k)) {
                                grid[i][j] = k;
                                if (isBoardFullyPlaced())
                                    return true;
                            }
                            grid[i][j] = 0;
                        }
                        return false;
                    }
                }
            }
            return true;
        }


        private boolean isValid(int row, int col, int num) {
            return isRowSafe(row, num) && isColumnSafe(col, num) && boxIsSafe(row, col, num);
        }



        private boolean boxIsSafe(int row, int col, int num) {
            int sqr = (int) Math.sqrt(length);
            int startRow = row - (row % sqr);
            int startCol = col - (col % sqr);

            System.out.println("box" + num);
            for (int i = startRow; i < startRow + sqr; i++) {
                for (int j = startCol; j < startCol + sqr; j++) {
                    if (grid[i][j] == num) return false;
                }
            }
            return true;
        }


        private boolean isColumnSafe(int col, int num) {
            int row = 0;
            while (row < length)
                if(grid[row++][col] == num) return false;
            return true;
        }

        private boolean isRowSafe(int row, int num) {
            int col = 0;
            while (col < length)
                if(grid[row][col++] == num) return false;
            return true;
        }

        private void printSolution() {
            for (int[] col : grid)
                System.out.println(Arrays.toString(col));
        }
    }
}
