package TutorialHorizon;

//Do a DFS

import kotlin.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Objective: Given a 2d grid map of ‘1’s (land) and ‘0’s (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * Assume all four edges of the grid are all surrounded by water.
 * Given such a grid, write an algorithm to find the number of islands in it.
 *
 *
 */
public class NumberOfIslandsDFSIterration {
    public static void main(String[] args) {

        int[][] islandGrid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        Islands islands = new Islands(islandGrid);
        islands.noOfIslands();
        islands.printVisited();

    }

    private static class Islands {
        int[][] islands;
        boolean[][] visited;
        int length;
        int height;

        Islands(int[][] islands) {
            this.islands = islands;
            this.length = islands.length;
            this.height = islands[0].length;

            visited = new boolean[length][height];

            for (int i = 0; i < length; i++)
                for (int j = 0; j < height; j++)
                    visited[i][j] = false;
        }

        void printVisited() {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++)
                    System.out.print("  " + visited[i][j]);
                System.out.println();
            }
        }

        void noOfIslands() {
            int count = 0;
            for (int i = 0; i < length; i++)
                for (int j = 0; j < i; j++)
                    if (!visited[i][j] && islands[i][j] == 1) {
                        isIsland(i, j);
                        count++;
                    }

            System.out.println(count + " Islands");
        }

        private void isIsland(int i, int j) {
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(i, j));

            while (!queue.isEmpty()){
                Pair<Integer, Integer> temp = queue.remove();
                int row = temp.getFirst();
                int col = temp.getSecond();
                if(row < 0 || col < 0 || row >= length || col >= height) continue;
                if (visited[row][col] || islands[row][col] == 0) continue;

                visited[row][col] = true; //mark visited

                queue.add(new Pair<>(row+1, col)); // move left
                queue.add(new Pair<>(row-1, col)); // move right

                queue.add(new Pair<>(row, col+1)); // move down
                queue.add(new Pair<>(row, col-1)); // move up
            }
        }
    }
}
