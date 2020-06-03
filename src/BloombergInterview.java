import java.util.HashMap;
import java.util.Map;

public class BloombergInterview {
    public static void main(String[] args) {

        StringSearch search = new StringSearch();
//        char[] items = {'z', 'y', 'z'};
//        System.out.println("String :" + search.shortestUniqueSubstring(items, "xyyzyzzyxxy"));

        int [] nums = {0,1,2,2,3,0,4,2};
        System.out.println(" remove nums " + search.removeElement(nums, 2));

    }


}

class StringSearch {

    //Given nums = [0,1,2,2,3,0,4,2], val = 2,
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue; //0,1,0,0,3,0,4,0

            nums[count++] = nums[i];
        }
        return count; //5
    }

    String shortestUniqueSubstring(char[] items, String string) {

        int start_index = 0;
        int last_index = items.length;
        String output = string.substring(start_index, last_index);
        while (start_index < string.length() - items.length && !isUniqueSubstring(output)) {
            if (isUniqueSubstring(string.substring(start_index, last_index)))
                return string.substring(start_index, last_index);
            start_index++;
            last_index++;
        }

        return "";
    }

    private boolean isUniqueSubstring(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            if (!map.containsKey(s))
                map.put(s, 1);
            else
                map.replace(s, map.get(s) + 1);
        }
        for (Map.Entry<Character, Integer> item : map.entrySet())
            if (item.getValue() > 1)
                return false;
        return true;
    }
}