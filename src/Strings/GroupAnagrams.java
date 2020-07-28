package Strings;

import kotlin.Pair;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String [] strings =  {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> items = solve(strings);

        for (List<String> item : items)
            System.out.println(Arrays.toString(item.toArray()));
    }

    /**
     * Create a map (string, list of indices)
     * Traverse through the list
     *     -  Sort every string in the list,
     *     -  if the sorted word is in map
     *          add its index to the map
     *     -  else create new list and add the index, and put in map
     *
     * Traverse the map
     *      and print the word at the index
     *
     * @param strings
     * @return
     */
    private static List<List<String>> solve(String[] strings) {

        HashMap<String, List<Integer>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            String item = sortString(strings[i]);
            if (!map.containsKey(item)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                map.put(item, integers);
            }else {
                List<Integer> pair = map.get(item);
                pair.add(i);
                map.put(item, pair);
            }

        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> pair = entry.getValue();
            List<String> temp = new ArrayList<>();
            for (int i : pair)
                temp.add(strings[i]);

            result.add(temp);
        }
        return result;
    }

    private static String sortString(String string) {
        StringBuilder result = new StringBuilder();
        char[] item = string.toCharArray();
        Arrays.sort(item);

        for (char i : item)
            result.append(i);

        return result.toString();
    }
}
