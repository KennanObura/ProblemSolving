package TutorialHorizon;

/**
 *
 * Objective: Given an array of numbers, write an algorithm to print all the subsets sum individually.
 *
 * Given Input: [1, 2]
 * Output: 3 1 2 0
 * Explanation: subsets are [0], [1], [2], [1, 2]
 *
 * Given Input: [2, 4, 6]
 * 12 6 8 2 10 4 6 0
 */
public class PrintSumOfAllSubsets {
    public static void main(String[] args) {
        int [] nums = {2, 4, 6};
        Sum sum = new Sum(nums);
        sum.find();

    }

    private static class Sum{
        int [] nums;
        Sum(int [] nums){
            this.nums = nums;
        }

        void find(){
            find(nums, 0, 0);
        }

        private void find(int[] nums, int i, int sum) {
            if(i == nums.length){
                System.out.println(sum + "");
                return;
            }
            find(nums, i+1, nums[i]+sum );
            find(nums, i+1, sum );
        }
    }
}
