package Arrays;

/**
 * Objective:  The maximum subarray problem is the task of
 * finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, -3, -4, 2, 7, -2, 3};
        System.out.println(maxSubArray(nums));


        int[] negatives = {-2, -3, -4, -2, -7, -2, -3,-11};
        System.out.print(maxSubArrayModified(negatives));
    }

    private static int maxSubArray(int[] nums) {
        int max_end_here = nums[0];
        int max_sofar = nums[0];

        for (Integer item : nums) {
            max_end_here += item;
            if (max_end_here < 0) max_end_here = 0;
            max_sofar = Math.max(max_end_here, max_sofar);
        }
        return max_sofar;
    }


    /**
     * Below modification will allow the program to work even if all the
     * elements in the array are negative
     */
    private static int maxSubArrayModified(int[] nums) {
        int max_end_here = nums[0];
        int max_sofar = nums[0];

        for (Integer item : nums) {
            max_end_here = Math.max(max_end_here , max_end_here+item);
            max_sofar = Math.max(max_sofar, max_end_here);
        }

        return max_sofar;
    }
}
