package TutorialHorizon;

import java.util.Arrays;

public class PermutationHeapAlgorithm {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permutation(nums);
    }

    static void permutation(int[] nums) {
        int length = nums.length;
        if (length == 0) return;

        permutation(nums, length);
    }

    private static void permutation(int[] nums, int length) {
        if (length == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < length; i++) {

            permutation(nums, length - 1);
            /*
             * In Heap algorithm for permutation, when n (size) is odd always pick the first elem
             * Pick ith elem when even
             */
            if (length % 2 == 0) swap(nums, i, length - 1);
            else swap(nums, 0, length - 1);

        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
