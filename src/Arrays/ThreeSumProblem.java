package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

//        List<List<Integer>> list = solve(nums, 0);

        Arrays.sort(nums);
        List<List<Integer>> list = solveRecur(nums, 0, 0, new ArrayList<>());
        for (List<Integer> lists : list)
            System.out.println(Arrays.toString(lists.toArray()));

    }

    /**
     * Sort items
     * We are looking for 3 elems (x,y,z) such that x+y+z = K
     * -   Traverse through ..N
     * -   Take one elem, x, as a fixed value, :: Now we look for z,y such that z+y = K-x
     * -   Scan through from i+1 till ..N comparing z+y against k-x,
     * -   If z+y == K-x, add xyz to list
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> solve(int[] nums, int K) {

        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int start = i + 1;
            int end = size - 1;
            int subSum = K - nums[i];

            while (start < end) {
                if (subSum == nums[start] + nums[end]) {
                    List<Integer> items = new ArrayList<>();
                    items.add(nums[i]);
                    items.add(nums[start]);
                    items.add(nums[end]);

                    if (!result.contains(items))
                        result.add(items);
                    start++;
                    end--;
                    continue;
                }

                if (subSum < nums[start] + nums[end])
                    start++;
                else end--;
            }
        }
        return result;
    }

    private static List<List<Integer>> solveRecur(int[] nums, int K, int index, List<List<Integer>> result) {
        if (index == nums.length) return result;

        int start = index + 1;
        int end = nums.length - 1;

        while (start < end) {
            List<Integer> elements = new ArrayList<>();
            int subSum =  nums[index] + nums[start] + nums[end];
//            System.out.println(subSum);
            if (subSum == K) {
                elements.add(nums[index]);
                elements.add(nums[start]);
                elements.add(nums[end]);

                if (!result.contains(elements)) {
                    result.add(elements);
                    solveRecur(nums, K, index + 1, result);
                }
            }

            if (subSum < K) start++;
            else end--;
        }
        return solveRecur(nums, K, index + 1, result);
    }
}
