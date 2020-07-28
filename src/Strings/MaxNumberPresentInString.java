package Strings;

import java.lang.*;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxNumberPresentInString {
    public static void main(String[] args) {
        String s = "213123123and544455523412423423424234234234";
        System.out.println(maxNumber(s));
    }

    private static int maxNumber(String string) {
        if (string.isEmpty()) return -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < string.length(); i++) {
            long item = 0;

            while (i < string.length() && isNumeric(string.charAt(i)))
                item = item * 10 + Integer.parseInt(Character.toString(string.charAt(i++)));

            System.out.println(item);
            max = Math.max(max, (int)item);
        }

        return Math.min(max, Integer.MAX_VALUE);
    }

    private static boolean isNumeric(char character) {
        String regex = "[+-]?[0-9][0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Character.toString(character));
        return matcher.find();
    }
}
