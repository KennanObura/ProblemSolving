package Arrays;

/**
 * Given an array with positive integers as elements indicating the maximum length of a
 * jump which can be made from any position in the array. Check if it is possible to have a
 * jumps combination so that you can eventually
 * reach the end of given array. Print “true” if it is possible, otherwise, print “false”.
 * <p>
 * Input :
 * [1, 5, 2, 1, 0, 2, 0]
 * Output :
 * true
 * <p>
 * Input :
 * [5, 4, 3, 2, 1, 0, 0]
 * <p>
 * Output :
 * false
 */
public class PossibleToJumpToEnd {
    public static void main(String[] args) {
        int[] jumps = {1, 5, 2, 1, 0, 2, 0};
        System.out.print(possible(jumps));
    }

    private static boolean possible(int[] jumps) {
        return possible(jumps, 0);
    }

    /**
     * This a very basic brute force approach in which we make all the possible jumps from any current position.
     * We start with the current position at index zero in the array, and make a
     * recursive call by changing the current position by adding all the possible jump
     * lengths one by one. We also need to make sure that we stay in bounds of
     * the given array, that is why we only make the jump if the current position after adding this jump length stays in bound.
     *
     * Positive Base case : If the current position is equal to array.length,
     * this means that we have successfully reached the end of the given array, that is, a jumps combination exists
     * with which we can reach end of given array, hence we return true from here.
     *
     * Negative base case : if maximum length of any jump possible from any current position is equal to zero,
     * this means that there is no way possible with which we can reach the end of the given array as we cannot move even a
     * single position from our current position.
     *
     * Time complexity Discussion :
     *
     * As from every point we are making all the possible jumps and in worst case from any position, we can make ‘n’ jumps and there are n possible spots from where we can make these jumps, therefore, worst time complexity of this algorithm for solving this problem is O(n^n), where ‘n’ is the length of the given array.
     * @param jumps
     * @param index
     * @return
     */
    private static boolean possible(int[] jumps, int index) {
        if (index == jumps.length-1) return true;
        if (jumps[index] == 0) return false;

        boolean possible = false;
        for (int i = 1; i <= jumps[index]; i++)
            if (i + index < jumps.length)
                possible = possible || possible(jumps, index + i);
        return possible;
    }
}
