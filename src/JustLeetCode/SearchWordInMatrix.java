package JustLeetCode;

import java.util.HashSet;
import java.util.Set;

public class SearchWordInMatrix {
    public static void main(String[] args) {
        char[][] matrix = {
                {'t', 'z', 'x', 'c', 'd'},
                {'a', 'h', 'n', 'z', 'x'},
                {'h', 'w', 'o', 'i', 'o'},
                {'o', 'r', 'n', 'r', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };

        String word = "horizon";
        searchWord(matrix, word);

    }

    private static void searchWord(char[][] matrix, String string) {
        Set<Character> set = new HashSet<>();
        char[] chartrs = string.toCharArray();

        for (char c : chartrs)
            set.add(c);

        int width = matrix.length;
        int length = matrix[0].length;
        boolean[][] visited = new boolean[width][length];

        boolean result = searchWord(matrix, visited, 0, 0, set, string);
        System.out.println("IS word present :" + result);
    }

    private static boolean searchWord(char[][] matrix, boolean[][] visited, int row, int column, Set<Character> set, String string) {
        int width = matrix.length;
        int length = matrix[0].length;

        if (set.isEmpty())
            return true;

        if (row < 0 || column < 0 || row >= width || column >= length || visited[row][column])
            return false;

        if (set.contains(matrix[row][column]))
            set.remove(matrix[row][column]);



        visited[row][column] = true;


        return (
                searchWord(matrix, visited, row + 1, column, set, string) &&
                        searchWord(matrix, visited, row - 1, column, set, string) &&
                        searchWord(matrix, visited, row, column + 1, set, string) &&
                        searchWord(matrix, visited, row, column - 1, set, string));
    }
}
