package Strings;

import java.util.Stack;

public class ConvertPostfixToPrefix {
    public static void main(String[] args) {

        String postfix = "ABC/-AK/L-*";
        System.out.println(toPrefix(postfix));
    }

    /**
     *
     * If the character is operand, push it to stack.
     * If the character is operator,
     * Pop operand from the stack, say it’s s1.
     * Pop operand from the stack, say it’s s2.
     * perform (operator s2 s1) and push it to stack.
     * Once the expression iteration is completed, initialize the result string and pop out from the stack and add it to the result.
     * @param postfix
     * @return
     */

    private static String toPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char character : postfix.toCharArray()) {
            if (isOperator(character)) {

                StringBuilder temp = new StringBuilder();
                temp.append(character);

                String item1 = stack.pop();
                String item2 = stack.pop();

                temp.append(item2);
                temp.append(item1);

                stack.push(temp.toString());
            } else
                stack.push(String.valueOf(character));
        }
        return stack.peek();
    }

    private static boolean isOperator(char character) {
        return switch (character) {
            case '*', '/', '-', '^', '+' -> true;
            default -> false;
        };
    }
}
