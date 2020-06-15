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

        Search search = new Search(board, items);
        search.findPossibleWords();

    }


    static private class Search {
        private final boolean[][] visited;
        private final char[][] grid;
        String[] dictionary;

        Search(char[][] grid, String[] dictionary) {
            this.grid = grid;
            this.dictionary = dictionary;
            this.visited = new boolean[grid.length][grid.length];
        }

        void findPossibleWords() {
            if (grid.length == 0)
                return;

            for (String s : dictionary) {
                Set<Character> set = new HashSet<>();

                for (int j = 0; j < s.length(); j++)
                    set.add(s.charAt(j));

                findPossibleWords(0, 0, set, s);
            }
        }


        private void findPossibleWords(int row, int column, Set<Character> set, String word) {
            int width = grid.length;
            int height = grid[0].length;

            if (row < 0 || column < 0 || row >= width || column >= height || visited[row][column] || set.isEmpty())
                return;

            if (set.contains(grid[row][column]))
                set.remove(grid[row][column]);

            if (set.isEmpty())
                System.out.println(word);

            visited[row][column] = true;
            findPossibleWords(row + 1, column, set, word);
            findPossibleWords(row - 1, column, set, word);
            findPossibleWords(row, column + 1, set, word);
            findPossibleWords(row, column - 1, set, word);

            visited[row][column] = false;
        }
    }
}






