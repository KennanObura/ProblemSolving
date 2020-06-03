import java.util.*;

public class NumericPermutations {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] nums = {1, 2, 3};
        permutation.permute(nums);

    }

    static private class Permutation {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            ArrayList<Integer> seen = new ArrayList<>();
            permute(nums, nums.length-1, seen);
            return result;
        }

        private void permute(int[] nums, int index, ArrayList<Integer> result) {
            if (index == 0) {
                System.out.println(Arrays.toString(nums));

                return;
            }

            for (int i = 0; i < nums.length; i++) {
                permute(nums, index - 1, result);
                if (index % 2 == 0)
                    swap(nums, i, index);
                else
                    swap(nums, 0, index);

            }
            permute(nums, index - 1, result);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
