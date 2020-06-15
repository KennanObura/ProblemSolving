package TutorialHorizon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an string and a dictionary of words,
 * find out if the input string can be broken into a space-separated sequence of one or more dictionary words.
 */
public class WordbreakProblem {
    public static void main(String[] args) {
        solution("IamSumit");
    }

    private static void solution(String word) {
        String[] dict = {"I", "have", "Jain", "Sumit", "am", "this", "dog"};
        List<String> dictionary = Arrays.asList(dict);

        solution(dictionary, word, "");
    }

    private static void solution(List<String> dictionary, String word, String result) {
        if (word.length() == 0) {

            System.out.println(result);
            return;
        }
//        System.out.println(word +" broken " + result);
        for (int i = 1; i < word.length(); i++){
            String prefix = word.substring(0, i);
            if (dictionary.contains(prefix))
                solution(dictionary, word.substring(i), result + " " + prefix);
        }


    }

}
