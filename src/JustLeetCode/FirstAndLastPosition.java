package JustLeetCode;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {

        int[] nums = {1,2,3,5,5,5,6,8};
        System.out.println(Arrays.toString(searchRange(nums, 5)));
    }

    static public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int position = doBinary(nums, 0, nums.length - 1, target);

        if (position == -1)
            return result;

        System.out.println("pos: " + position);
        int last_position = position;

        while (position >= 0 && nums[position] == target)
                position--;

        while (last_position < nums.length && nums[last_position] == target)
            last_position++;


        result[0] = position+1;
        result[1] = last_position-1;
        return result;
    }

    private static int doBinary(int[] nums, int start, int last, int target) {
        int mid = start + (last - start) / 2;
        if (start > last) return -1;
        if (nums[mid] == target) return mid;

        if (target > nums[mid]) return doBinary(nums, mid + 1, last, target);
        return doBinary(nums, start, mid - 1, target);
    }
}
