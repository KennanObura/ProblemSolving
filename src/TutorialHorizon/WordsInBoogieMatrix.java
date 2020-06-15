package TutorialHorizon;

import java.util.*;

public class WordsInBoogieMatrix {
    public static void main(String[] args) {
        Character[][] board = {
                {'M', 'S', 'E'},
                {'R', 'A', 'T'},
                {'L', 'O', 'N'}
        };
        String[] words = {"STAR", "NOTE", "SAND", "STONE", "MARS"};
        Boogie bogie = new Boogie(board, words);

        bogie.search();
//            System.out.print();
    }
}

class Boogie {
    private final boolean[][] processed;
    private final Character[][] board;
    private final String[] dictionary;


    Boogie(Character[][] board, String[] dictionary) {
        this.board = board;
        this.dictionary = dictionary;
        processed = new boolean[board.length][board.length];
    }

    /**
     * For every word, check the cells one by one, doing an extensive search to every possible movements [8 movements]
     * Return true if a word is found
     */
    void search() {

        for (String word : dictionary) {
            Set<Character> set = new HashSet<>();  //stores the current word
            for (Character c : word.toCharArray())
                set.add(c);
            search(0, 0, set, board.length, word);
        }
    }

    private void search(int row, int col, Set<Character> set, int length, String word) {
        if (row < 0 || col < 0 || row >= length || col >= length || set.isEmpty() || processed[row][col])
            return;

        set.remove(board[row][col]);

        if (set.isEmpty()) {
            System.out.println(word);
            return;
        }

        processed[row][col] = true;
        search(row + 1, col, set, length, word); //down
        search(row - 1, col, set, length, word); //up
        search(row, col + 1, set, length, word); //right
        search(row, col - 1, set, length, word); //left
        search(row + 1, col + 1, set, length, word);
        search(row - 1, col + 1, set, length, word);
        search(row - 1, col - 1, set, length, word);
        search(row + 1, col - 1, set, length, word);

        processed[row][col] = false;

    }


}
