package Strings;

/**
 *
 * Objective: Given two strings, write a program to check if any of the given string is a subsequence of another string.
 * Example if given strings are
 * A and B then EITHER A is subsequence of B OR B is subsequence of A, program should return true.
 */
public class CheckForSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("amount", "mount"));
    }

    private static boolean isSubsequence(String A, String B){
        if(A.isEmpty() || B.isEmpty())
            return false;
        String largerst = A.length() > B.length() ? A : B;
        String smallest = A.length() < B.length() ? A : B;
        return isSubsequence(largerst, smallest, 0, 0);
    }

    private static boolean isSubsequence(String largerst, String smallest, int i, int sm_index) {
        if(sm_index == smallest.length()) return true;
        if(i >= largerst.length()) return false;
        if(largerst.charAt(i) == smallest.charAt(sm_index)) sm_index++;
        return isSubsequence(largerst, smallest, i+1, sm_index);
    }


//    private static boolean isSubsequence(String A, String B){
//        if(A.isEmpty() || B.isEmpty())
//            return false;
//
//        String largerst = A.length() > B.length() ? A : B;
//        String smallest = A.length() < B.length() ? A : B;
//
//        int index = 0;
//        for (int i = 0; i < largerst.length() ; i++) {
//            if(largerst.charAt(i) == smallest.charAt(index))
//                index++;
//            if(index == smallest.length())
//                return true;
//        }
//        return false;
//    }
}
