package TutorialHorizon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integers N and K, Write an algorithm to find subsets of size K from the numbers 1 to N.
 * N = 5
 * K = 3
 * Output:
 * [1, 2, 3]
 * [1, 2, 4]
 * [1, 2, 5]
 * [1, 3, 4]
 * [1, 3, 5]
 * [1, 4, 5]
 * [2, 3, 4]
 * [2, 3, 5]
 * [2, 4, 5]
 * [3, 4, 5]
 * <p>
 * N = 6
 * K = 5
 * Output:
 * [1, 2, 3, 4, 5]
 * [1, 2, 3, 4, 6]
 * [1, 2, 3, 5, 6]
 * [1, 2, 4, 5, 6]
 * [1, 3, 4, 5, 6]
 * [2, 3, 4, 5, 6]
 */
public class CombinationAllSubsetsOfSizeK {
    public static void main(String[] args) {
        subsets(5, 3);
    }

    private static void subsets(int N, int K) {
        subsets(N, K, 1, new ArrayList<Integer>());
    }

    private static void subsets(int N, int K, int start, ArrayList<Integer> list) {
        if (K == 0) {
            System.out.println(list);
            return;
        }

        for (int i = start; i <= N; i++) {
            list.add(i);
            subsets(N, K - 1, i + 1, list);
            list.remove(list.size()-1);
        }

    }
}
