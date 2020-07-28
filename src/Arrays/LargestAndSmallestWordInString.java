package Arrays;

import kotlin.Pair;

/**
 * Objective: Given a String, write a program to find the largest and smallest word in it.
 */
public class LargestAndSmallestWordInString {
    public static void main(String[] args) {
        String string = "This problem is solved at the Algorithms tutorial horizon";
        Pair<String, String> pair = findSmallestAndLargest(string);
        System.out.println("Max word is :" + pair.getSecond());
        System.out.println("Min word is :" + pair.getFirst());
    }

    private static Pair<String, String> findSmallestAndLargest(String string) {
        String[] words = string.split(" ");

        int min = Integer.MAX_VALUE;
        String minWord = null;
        int max = Integer.MIN_VALUE;
        String maxWord = null;

        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
                maxWord = word;
            }

            if(word.length() < min){
                min = word.length();
                minWord = word;
            }

        }
        return new Pair<>(minWord, maxWord);
    }
}
