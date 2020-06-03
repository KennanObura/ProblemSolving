package JustLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxConcecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {5,6,4, 100};
        System.out.println("" + getMaxSequence(nums));
    }

    private static int getMaxSequence(int[] nums) {
        Map<Integer, Boolean> set = new HashMap<>();
        for (int i : nums) set.put(i, false);


        int max_count = Integer.MIN_VALUE;
        int count = 0;


//        while (!set.isEmpty()) {
//            if (set.contains(item + 1) || set.contains(item - 1)) {
//                if (set.contains(item + 1))
//                    item = item + 1;
//                else
//                    item = item - 1;
//                set.remove(item);
//                count++;
//            } else {
//                max_count = Math.max(max_count, count);
//                item = set.iterator().next();
//                set.remove(item);
//            }
//        }

        for(Map.Entry<Integer, Boolean> i: set.entrySet()){

//            int elem = i.getKey();
//            while (set.containsKey(elem)){
//                elem += 1;
//                if(set.containsKey(elem) && !set.get(elem)) {
//                    System.out.println("" + elem);
//                    set.replace(elem, true);
//                    count++;
//                }else continue;
//            }

            int elem_less = i.getKey();
            while (set.containsKey(elem_less)){
                if(set.containsKey(elem_less) && !set.get(elem_less)) {
                    System.out.println("" + elem_less);
                    set.replace(elem_less, true);
                    elem_less = elem_less- 1;
                    count++;
                }else continue;
            }

            max_count = Math.max(max_count, count);
        }
        return max_count;
    }

}
