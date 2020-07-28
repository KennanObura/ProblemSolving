package Arrays;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        int rowLength = grid.length;
        int colLength = grid[0].length;

        boolean[][] visited = new boolean[rowLength][colLength];


        solve(grid, visited, 0, 0, 0);

        for (int[] items : grid)
            System.out.println(Arrays.toString(items));
    }

    private static void solveInPlace(int[][] grid) {
        boolean firstRow = false;
        boolean firstCol = false;

        for (int[] ints : grid)
            if (ints[0] == 0) {
                firstRow = true;
                break;
            }

        for (int i = 0; i < grid[0].length; i++)
            if (grid[0][i] == 0) {
                firstCol = true;
                break;
            }

        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                if (grid[i][j] == 0) {
                    grid[i][0] = 0;
                    grid[0][j] = 0;
                }

        }

        private static void solve ( int[][] grid, boolean[][] visited, int row, int col, int count){
            int rowLength = grid.length;
            int colLength = grid[0].length;

            if (count == rowLength * colLength || row >= rowLength || col >= colLength) return;

            if (grid[row][col] == 0 && !visited[row][col]) {
                setRowColZeros(grid, visited, row, col);
            }
            solve(grid, visited, row + 1, col, count + 1);
            solve(grid, visited, row, col + 1, count + 1);
        }

        private static void setRowColZeros ( int[][] grid, boolean[][] visited, int row, int col){
            int i = row;
            while (i > -1) {
                if (grid[i][col] != 0) {
                    visited[i][col] = true;
                    grid[i][col] = 0;
                }
                i--;
            }

            i = row;
            while (i < grid.length) {
                if (grid[i][col] != 0) {
                    visited[i][col] = true;
                    grid[i][col] = 0;
                }
                i++;
            }


            int j = col;
            while (j > -1) {
                if (grid[row][j] != 0) {
                    grid[row][j] = 0;
                    visited[row][j] = true;
                }
                j--;
            }

            j = col;
            while (j < grid.length) {
                if (grid[row][j] != 0) {
                    grid[row][j] = 0;
                    visited[row][j] = true;
                }
                j++;
            }
        }
    }
