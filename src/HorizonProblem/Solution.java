package HorizonProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        int [] nums = {1, 5, 7, 1, -1};
        Count solution = new Count(nums);
        System.out.println(solution.countPairs(6) + "");
    }

    static private class Count {
        int[] nums;

        Count(int[] nums) {
            this.nums = nums;
        }

        int countPairs(int sum) {
            return countPairs(nums, sum);
        }

        private int countPairs(int[] nums, int sum) {
            Set<Integer> map = new HashSet<>();

            for (int i : nums) map.add(i);

            int count = 0;
            for (int i : nums)
                if (map.contains(sum - i)) count++;

            return count;
        }


    }
}
