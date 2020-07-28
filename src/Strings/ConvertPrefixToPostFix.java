package Strings;

import java.util.Stack;

public class ConvertPrefixToPostFix {
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println(toPostfix(prefix));
    }

    /**
     * Read the Prefix expression in reverse order (from right to left)
     * If the symbol is an operand, then push it onto the Stack
     * If the symbol is an operator, then pop two operands from the Stack
     * Create a string by concatenating the two operands and the operator after them.
     * string = operand1 + operand2 + operator
     * And push the resultant string back to Stack
     * Repeat the above steps until end of Prefix expression.
     * @param prefix
     * @return
     */
    private static String toPostfix(String prefix) {

        Stack<String> stack = new Stack<>();

        for (int i = prefix.length()-1; i >= 0; i--) {
            char character = prefix.charAt(i);

            if(isOperator(character)) {
                int j = 0;
                StringBuilder stringBuilder = new StringBuilder();

                while (!stack.isEmpty() && j++ < 2)
                    stringBuilder.append(stack.pop());

                stringBuilder.append(character);
                stack.push(stringBuilder.toString());
            }

            else if (!isOperator(character))
                stack.push(String.valueOf(character));
        }

        return stack.pop();
    }

    private static boolean isOperator(char character) {
        return switch (character) {
            case '*', '+', '/', '-', '^' -> true;
            default -> false;
        };
    }
}
