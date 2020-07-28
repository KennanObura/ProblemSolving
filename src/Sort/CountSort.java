package Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 8, 3, 3, 1};
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {

        //space of o(n)
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        // complexity o(n)
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
            max = Math.max(max, i);
        }

        int position = 0; // o(i)
        //complexity o(k+m) :: k= max, m=max frequency in map
        for (int i = 0; i <= max; i++) {
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i); j++) {
                    nums[position + j] = i;
                    position++;
                }
            }
        }
        return nums;
    }
}
