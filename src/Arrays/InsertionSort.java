package Arrays;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {2,1,9,4,3,5};
        sortRecur(nums, 0);
    }

    private static int[] sort(int[] nums) {

        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            int K = nums[i];

            while (i - 1 >= 0 && K < nums[i - 1]) {
                nums[i] = nums[i - 1];
                i--;
                System.out.println(Arrays.toString(nums));
            }
            nums[i] = K;
        }

        return nums;
    }

    private static void sortRecur(int [] nums, int index){
        if(index >= nums.length ) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        int pointer = index - 1;
        int K = nums[index];

        while (pointer >= 0 && K < nums[pointer]) {
            nums[index] = nums[pointer];
            index--;
            pointer = index-1;
        }
        nums[index] = K;
        sortRecur(nums, index+1);
    }

    private static int[] sortB(int[] nums) {
        if (nums.length == 1) return nums;

        int pointer = 0;

        for (int i = 1; i < nums.length; i++) {
            pointer = i - 1;
            int K = nums[i];

            while (pointer >= 0 && K < nums[pointer]) {
                nums[i] = nums[pointer];
                i--;
                pointer = i-1;
                System.out.println(i);
            }

            nums[i] = K;
        }
        return nums;
    }
}
