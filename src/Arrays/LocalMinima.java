package Arrays;

/**
 * An element is local minima if it is less than its neighbors.
 * <p>
 * int [] arr = {10, 5, 3, 6, 13, 16, 7};
 * Output: 3
 * int []arr = {11,12,13,14};
 * Output: 11
 * <p>
 * int []arr = {10};
 * Output: 10
 * <p>
 * int []arr = {8,6};
 * Output: 6
 */
public class LocalMinima {
    public static void main(String[] args) {
        int[] arr = {16, 7};
        System.out.print(findMinima(arr, 0, arr.length));
    }

    /**
     * Efficient approach
     * You can use binary search to find local minima.
     * <p>
     * Worst case time complexity will be o(log n).
     * Here is simple algorithm
     * <p>
     * Find the mid element
     * If mid element is less than both the neighbor then return it.
     * If mid element is greater than its left neighbor, then go left
     * else go right.
     */

    private static int findMinima(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;

        if (mid == 0 || mid == nums.length-1)
            return nums[mid];

        if (nums[mid] < nums[mid - 1] &&  nums[mid] < nums[mid + 1])
            return nums[mid];

        if (nums[mid] > nums[mid - 1])
            return findMinima(nums, start, mid);
        else
            return findMinima(nums, mid + 1, end);
    }

}
