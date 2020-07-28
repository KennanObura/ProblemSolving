package Strings;

import java.util.ArrayList;

public class StepsToConvertStringToAnother {
    public static void main(String[] args) {
        printSteps("FRIED", "FIRED");
    }

    private static void printSteps(String stringA, String stringB) {
        if (stringA.isEmpty() || stringB.isEmpty())
            throw new RuntimeException("Empty string applied");
        printSteps(stringA, stringB, new ArrayList<>());
    }

    /**
     * Given source and target strings.
     * Maintain two lists, allCombinations and currentPath.
     * allCombinations – Will keep track of all the combinations that are tried for the source string. Maintaining this will prevent us from going to loops.
     * currentPath – Will keep track of the current path, once the source reaches to target, we will print this.
     * Iterate through the string, for each consecutive characters at index i, j
     * Swap characters at indexes i and j and generate new string newSource.
     * Check if  newSource is already tried ( part of allCombinations), if yes then skip it.
     * Else add it to allCombinations and make a recursive call with source= newSource, allCombinations and currentPath (add new Source to currentPath).
     * Base Case: if source equals to target, print currentPath and return.
     *
     * @param stringA
     * @param stringB
     */

    private static void printSteps(String stringA, String stringB, ArrayList<String> tried) {


        if (stringA.equals(stringB)) return;

        for (int i = 0; i < stringB.length() - 1; i++) {
            String string = swap(new StringBuilder(stringB), i, i + 1);
            if (!tried.contains(string)) {
                tried.add(string);
                printSteps(stringA, string, tried);
            }
        }

        System.out.println(stringB);
    }

    private static String swap(StringBuilder string, int i, int j) {
        char temp = string.charAt(i);
        string.setCharAt(i, string.charAt(j));
        string.setCharAt(j, temp);

        return string.toString();
    }
}
