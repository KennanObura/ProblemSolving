package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 2, 3, 4, 4, 5};
        count(arr);
    }

    private static void count(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums)
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);

        for (Map.Entry<Integer, Integer> item : map.entrySet())
            System.out.println("Item :" + item.getKey() + " freg: " + item.getValue());

    }

}
