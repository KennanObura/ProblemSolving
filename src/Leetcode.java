import java.util.HashMap;
import java.util.Stack;

public class Leetcode {
    public static void main(String[] args) {

        System.out.println(longestValidParentheses(")()())"));

    }

    static int longestValidParentheses(String s) {


        Stack<Character> stack = new Stack<>();
        int length_count = 0;
        int max_length = Integer.MIN_VALUE;
        char opening = '(';
        char closing = ')';


        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if(chr == opening)
                stack.add(chr);

            if(!stack.isEmpty() && stack.peek() == opening && chr == closing){
                stack.pop();
                length_count += 2;
            }

            if(stack.isEmpty() && chr == closing){
                if(max_length < length_count)
                    max_length = length_count;
                length_count = 0;
            }


        }
        return max_length;
    }
}
