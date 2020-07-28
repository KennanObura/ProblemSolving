package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithSumK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 9, -2, -4};
        pairs(nums, 5);
    }

    /**
     *
     * - Create a map to store frequency of each number in the array. (Single traversal is required)
     * - In the next traversal, for every element check if it can be combined with any other element
     * (other than itself!) to give the desired sum. Increment the counter accordingly.
     * - After completion of second traversal, we’d have twice the required value stored in counter
     * because every pair is counted two times. Hence divide count by 2 and return.
     * @param num
     * @param sum
     */

    public static void pairs(int[] num, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : num) {
            if (!map.containsKey(i))
                map.put(i, 0);
            map.put(i, map.get(i) + 1);
        }

        int count = 0;
        for (Integer i: num){
            if(map.containsKey(sum-i))
                count += map.get(sum-i);

            if (sum-i == i)
                count--;
        }
        System.out.print(count/2);
    }
}
