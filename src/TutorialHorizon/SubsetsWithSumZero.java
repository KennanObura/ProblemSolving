package TutorialHorizon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Objective: Given an array of integers write an algorithm to find all the subsets for which sum is equal to zero.
 * The array contains both positive and negative integers.
 *
 * Given Array: [8, 3, 5, 1, -4, -8], required sum: 0
 * Output:
 * [-8, -4, 1, 3, 8]
 * [-8, 3, 5]
 * [-8, 8]
 * [-4, 1, 3]
 *
 *
 * 1. sort elements in ascending order
 *
 * 2. def currentsum = 0, index = 0, resultList = null
 *
 * iterate thru an array
 *      - put to list,
 */
public class SubsetsWithSumZero {
    public static void main(String[] args) {
        int [] arrA = {8,3,5,1,-4,-8};
        findSum(arrA);
    }

    static void findSum(int [] nums){
        Arrays.sort(nums);
        findSum(nums, 0, 0, new ArrayList<>());
    }

    static void findSum(int [] nums, int currentSum, int index, ArrayList<Integer> result){
        if(currentSum == 0 && !result.isEmpty()){
            System.out.println(result + "");
            return;
        }


        for (int i = index; i <  nums.length; i++) {

            if(currentSum + nums[i] > 0) break;

            result.add(nums[i]);
            findSum(nums, currentSum+nums[i], i+1, result);
            result.remove(result.size()-1);
        }
    }
}
