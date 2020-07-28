package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentString {
    public static void main(String[] args) {
        String[] strings = {"Algorithms", "String", "Integer", "Integer", "Algorithms", "String", "Integer", "Algorithms", "String", "Algorithms"};
        System.out.println(frequent(strings));
    }

    private static String frequent(String[] strings) {
        if (strings.length == 0) return "";
        if (strings.length == 1) return strings[0];

        HashMap<String, Integer> map = new HashMap<>();

        for (String i : strings)
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);

        String frequent = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() > max) {
                max = entry.getValue();
                frequent = entry.getKey();
            }

        return frequent;
    }
}
