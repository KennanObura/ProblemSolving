package Arrays;

import java.util.ArrayList;

/**
 *
 * Given an unsorted arrays nums, find all sub arrays with sum K
 */
public class SubarraysWithSumK {
    public static void main(String[] args) {
        int[] arr = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int sum = 7;
        subarrays(arr, 0,0, 0, sum);
    }


    private static void subarrays(int [] nums, int K){

    }

    private static void subarrays(int [] nums, int index, int start, int sum,  int K){
        if(index >= nums.length) {

            return;
        }

        if(nums[index] == K) {
            System.out.println(nums[index]);
        }


        while (sum > K)
            sum -= nums[start++];

        if(sum == K) {
            for (int i = start; i < index; i++)
                System.out.print(nums[i] + " ");
            System.out.println(" ");
        }

        subarrays(nums, index+1, start, sum+nums[index], K);

    }
}
