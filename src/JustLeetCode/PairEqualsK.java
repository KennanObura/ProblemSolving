package JustLeetCode;

import java.util.*;

public class PairEqualsK {
    public static void main(String[] args) {

//        int[] items = {0, 5, 4, 6, 3, 7, 2, 10};
        int[] items = {  -1, 0, 1, 2, -1, -4};

//        findPairs(items, 10);
        List<List<Integer>>  list = findTriple(items, 0);
        for (List<Integer> item : list) {
            int [] temp = new int[item.size()];
            System.out.println(item.toArray());
        }
    }

    static private void findPairs(int[] nums, int sum) {
        Set<Integer> map = new HashSet<>();
        for (int i : nums) {
            if (map.contains(sum - i))
                System.out.println("Elems are " + i + " and " + (sum - i));
            map.add(i);
        }
    }

    static private List<List<Integer>> findTriple(int[] nums, int sum) {
        //O(N^3)
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if(nums[i] + nums[j] + nums[k] == sum)
//                        System.out.println("Elems are " + nums[i] + " , " + nums[j] + " and " + nums[k]);
//                }
//
//            }
//        }

        //O(N^2)
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        //O(N^2)
        for (int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;

            while (start < end){
                int sum_temp = nums[i] + nums[start] + nums[end];
                List<Integer> inner = new ArrayList<>();
                if(sum_temp == sum) {
                    System.out.println("Elems are " + nums[i] + " , " + nums[start] + " and " + nums[end]);
                    inner.add(nums[i]);
                    inner.add(nums[start]);
                    inner.add(nums[end]);
                    if(!result.contains(inner)) result.add(inner);
                }
                if (sum_temp < sum)
                    start++;
                else end--;

            }

        }

        return result;
    }
}
