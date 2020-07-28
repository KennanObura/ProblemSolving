package Arrays;


/**
 * Given an array of positive integers and integer ‘K’. Write an algorithm to count all
 * the possible sub arrays where product of all the elements in the sub array is less than k.
 * <p>
 * Example:
 * <p>
 * Int [] nums = {10, 4, 2, 6};
 * K = 100
 * <p>
 * Output: 9
 * Sub arrays: [10], [10 4], [10, 4, 2], [4], [4, 2], [4, 2, 6], [2], [2, 6], [6]
 */
public class CountSubArraysWithProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 4, 2, 6};
        int K = 100;
        System.out.print(countElements(nums, K));
    }

    private static int countElements(int[] nums, int K) {
        return countElements(nums, K, nums[0], 0, 1, 0);
    }

    private static int countElements(int[] nums, int K, double product, int start, int end, int count) {
        if (nums.length == 1 && nums[0] < K) return nums[0];
        if (end >= nums.length) return count;

        if (product < K) count += end - start;
        else product /= nums[start++];

        System.out.println(nums[end]);
        System.out.println("prod "+ end);

        product *= nums[end];
        return countElements(nums, K, product, start, end + 1, count);
    }
}
