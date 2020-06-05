import java.util.HashSet;
import java.util.Set;

public class matrixBoardDFS {
    public static void main(String[] args) {

        char[][] board = {
                {'M', 'S', 'E'},
                {'R', 'A', 'T'},
                {'L', 'O', 'N'}
        };

        String[] items = {"STAR", "NOTE", "SAND", "STONE"};

        Search search = new Search();
        search.findPossibleWords(board, items);

    }


    static private class Search {
        void findPossibleWords(char[][] grid, String[] dictionary) {
            if (grid.length == 0)
                return;
            int width = grid.length;
            int height = grid[0].length;


            for (String s : dictionary) {
                Set<Character> set = new HashSet<>();
                boolean[][] visited = new boolean[width][height];

                for (int j = 0; j < s.length(); j++)
                    set.add(s.charAt(j));

                findPossibleWords(grid, visited, 0, 0, set, s);
            }

        }


        private void findPossibleWords(char[][] grid, boolean[][] visited, int row, int column, Set<Character> set, String word) {
            int width = grid.length;
            int height = grid[0].length;

            if (row < 0 || column < 0 || row >= width || column >= height || visited[row][column] || set.isEmpty())
                return;

            if (set.contains(grid[row][column]))
                set.remove(grid[row][column]);

            if (set.isEmpty())
                System.out.println(word);

            visited[row][column] = true;
            findPossibleWords(grid, visited, row + 1, column, set, word);
            findPossibleWords(grid, visited, row - 1, column, set, word);
            findPossibleWords(grid, visited, row, column + 1, set, word);
            findPossibleWords(grid, visited, row, column - 1, set, word);
        }
    }
}






