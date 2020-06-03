import kotlin.Pair;

import java.util.Stack;

public class DFSInMatrix {
    public static void main(String [] args){
        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printDFSRecursive(grid);
        System.out.println("==================Iterative==============");
        printDFSIterative(grid);
    }

    static void printDFSRecursive(int [][] grid){
        if(grid.length == 0)
            return;
        int width = grid.length;
        int height = grid[0].length;
        boolean [][] visited = new boolean[width][height];

        printDFSRecursive(grid, 0,0, visited);

    }

    static void printDFSIterative(int [][] grid){
        if(grid.length == 0)
            return;
        int width = grid.length;
        int height = grid[0].length;
        boolean [][] visited = new boolean[width][height];

        printDFSIterative(grid, visited);
    }


    /**
     * Def a Pair(row, column)
     * Def a stack and put first item to stack
     * Def a 2D matrix of boolean and mark false
     *
     * Do while stack not empty
     * pop and mark spot visited
     * push (row+1) to stalk
     * push (row-1) to stalk
     * push (column +1)
     * push (column -1)
     *
     *
     * @param grid 2d matrix
     * @param visited 2d matrix with false
     */

    static void printDFSIterative(int [][] grid, boolean[][] visited){
        int length = grid.length;
        int height = grid[0].length;
        Pair<Integer, Integer> spot = new Pair<>(0,0);
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        stack.push(spot);

        while (!stack.isEmpty()){
            Pair<Integer, Integer> pair = stack.pop();

            int row = pair.getFirst();
            int column = pair.getSecond();

            if(row < 0 || column < 0 || row > length-1 || column > height-1 || visited[row][column])
                continue;

            visited[row][column] = true;
            System.out.println("" + grid[row][column]);

            stack.push(new Pair<>(row, column-1)); // go right
            stack.push(new Pair<>(row, column+1)); //go left
            stack.push(new Pair<>(row-1, column));
            stack.push(new Pair<>(row+1, column));
        }
    }



    /***
     *
     * Define a 2D Matrix of same size as give Matrix and mark holes false
     * Def row = 0
     * Def col = 0
     *
     * # helper (recursive function)
     *  - Base case.
     *      Stop when col/row is out of range / spot marked true
     *
     *  - Mark hole true; (Visited)
     *  - Move to Right ### Recursive call (row ++)
     *  - Move to Left  ###     ""  (row --)
     *  - Move down ###   "" (col ++)
     *  - Move up ### "" (col--)
     *
     *
     */


    static void printDFSRecursive(int [][] grid, int row, int column, boolean [][] visited){
        int width = grid.length;
        int height = grid[0].length;
        if(row < 0 || column < 0 || row > width-1 || column > height-1 || visited[row][column])
            return;

        //mark spot visited
        visited[row][column] = true;
        System.out.println("" + grid[row][column]);
        printDFSRecursive(grid, row+1, column, visited); // go right
        printDFSRecursive(grid,row-1, column, visited); //go left
        printDFSRecursive(grid, row, column+1, visited); //go down
        printDFSRecursive(grid, row, column-1, visited); //go up

    }
}
