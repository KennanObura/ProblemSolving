package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Objective : Given an string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of one or more dictionary words.
 * <p>
 * Example:
 * <p>
 * dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
 * <p>
 * String = "IamSumit"
 * <p>
 * Output: "I am Sumit"
 * <p>
 * String ="thisisadog"
 * <p>
 * Output : String can't be broken
 */
public class WordBreak {
    public static void main(String[] args) {

        String[] dict = {"I" , "have", "Jain", "Sumit", "am", "this", "dog"};
        String sub = "IamSumit";
        System.out.println(solve(dict, sub));
    }

    private static Boolean solve(String[] dictionary, String word) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : dictionary)
            if (!map.containsKey(s)) map.put(s, 1);
            else map.put(s, map.get(s) + 1);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            String tocheck = word.charAt(i) + "";
            while (i+1 < word.length() && !map.containsKey(tocheck)) {
                tocheck += word.charAt(i+1);
                i++;
            }

            if (map.containsKey(tocheck)) {
                result.append(tocheck);
                System.out.println(result);
            }
        }
        return word.equals(result.toString());
    }
}
