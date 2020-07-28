package Arrays;

import java.util.Arrays;

/**
 * Given an array containing zeroes, ones and twos only. Write a function to sort the given array in O(n) time complexity.
 * <p>
 * Input :
 * [1, 2, 2, 0, 0, 1, 2, 2, 1]
 * Output :
 * [0, 0, 1, 1, 1, 2, 2, 2, 2]
 */
public class SortArraysOf012 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 0, 0, 1, 2, 2, 1};
//        System.out.println(Arrays.toString(sort(nums)));

        System.out.println(Arrays.toString(sortDutchFlag(nums)));
    }

    /**
     * Basic algorithm
     * @param nums
     * @return
     */
    private static int[] sort(int[] nums) {
        int zeros = 0;
        int ones = 0;

        for (int i : nums) {
            if (i == 0) zeros++;
            if (i == 1) ones++;
        }

        int i = 0;
        while (zeros > 0) {
            nums[i++] = 0;
            zeros--;
        }

        while (ones > 0) {
            nums[i++] = 1;
            ones--;
        }

        while (i < nums.length)
            nums[i++] = 2;

        return nums;
    }


    /**
     *
     * Dutch flag algorithm
     * have three pointers, :: low, mid, high -> Partitions array into 4 (0-low-1, low -mid-1, unexplored, mid-high )
     * and swap accordingly
     *
     */

    private static int[] sortDutchFlag(int[] nums) {
        int low = 0 , mid = 0;
        int high = nums.length -1;

        while (mid <= high){
            if(nums[mid] == 0) {
                nums[low] = swap(nums[mid], nums[mid] = nums[low]);
                low++;
                mid++;
            }
            else if(nums[mid] == 2){
                nums[high] = swap(nums[mid], nums[mid] = nums[high]);
                high--;
            }else
                mid++;
        }
        return nums;

    }

    private static int swap(int num, int i) {
        return num;
    }

}
