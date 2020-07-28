package backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1}
        };

        Maze maze = new Maze(grid);
        maze.solve();

    }

    private static class Maze {
        int[][] maze;
        int path = 0;
        int[][] solution;
        int mazeLength;
        int count = 1;

        Maze(int[][] maze) {
            this.maze = maze;
            this.mazeLength = maze.length;
            solution = new int[maze.length][maze.length];
        }

        private void solve(){
            if(isValidPath(0,0)) printMaze();
            else System.out.println("No path");
        }

        private void printMaze() {
            for(int [] col : solution)
                System.out.println(Arrays.toString(col));
        }



        private boolean isValidPath(int row, int col) {

            if (row >= mazeLength || col >= mazeLength || row < 0 || col < 0 || maze[row][col] == 0 || solution[row][col] != 0) {
                return false;
            }

            solution[row][col] = path++;

            if (row == mazeLength-1 && col == mazeLength-1) return true;


            if (isValidPath(row + 1, col)) return true;
            if (isValidPath(row - 1, col)) return true;
            if (isValidPath(row, col + 1)) return true;
            if (isValidPath(row, col - 1)) return true;

            solution[row][col] = 0;
            path--;
            return false;
        }
    }
}
