package JustLeetCode;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(" " +isPalindrome("muum"));
    }

    private static boolean isPalindrome(String string){
//       return isPalindrome(string, string.length());
        return isPalindrome(string, 0, string.length()-1);
    }

    private static boolean isPalindrome(String string, int start, int end){
        if(start >= end) return true;
        if(string.charAt(start) != string.charAt(end))
            return false;
        return isPalindrome(string, start+1, end-1);
    }

    private static boolean isPalindrome(String string, int length){
        if(string.isEmpty()) return false;
        if(string.length() == 1) return true;

        int start = 0;
        int last = length-1;

        while (start < last){
            if(string.charAt(start) != string.charAt(last))
                return false;
            start++;
            last--;
        }
        return true;
    }
}
