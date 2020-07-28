package GeekforGeeks.TopBacktracking;

import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {

        int[][] grid = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        Maze maze = new Maze(grid);
        maze.solve();
    }

    private static class Maze {
        Maze(int[][] maze) {
            this.maze = maze;
            this.N = maze.length;
            this.solution = new int[N][N];
        }

        final private int[][] maze;
        final private int[][] solution;
        final private int N;
        private int path = 0;


        private void solve() {
            if (pathExist(0, 0)) printPath();
            else System.out.println("No path found");
        }

        private boolean pathExist(int row, int col) {
            if (!canMove(row, col)) return false;

            solution[row][col] = path++;

            if (row == N - 1 && col == N - 1) return true;

            if (pathExist(row + 1, col)) return true;

            if (pathExist(row, col + 1)) return true;

            solution[row][col] = 0;
            path--;
            return false;
        }

        private boolean canMove(int row, int col) {
            return (row < N && col < N && solution[row][col] == 0 && maze[row][col] == 1);
        }

        private void printPath() {
            for (int[] col : solution)
                System.out.println(Arrays.toString(col));
        }
    }
}
