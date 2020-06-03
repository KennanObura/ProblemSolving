package JustLeetCode;

import java.math.BigInteger;

public class MultiplyString {
    public static void main(String[] args) {
        int[] items = {16, 19, 21, 25, 3, 5, 8, 10};
        secondLargest(items);
    }

    static void secondLargest(int[] nums) {
        int largest = nums[0];
        int second = largest;
        for (int i : nums)
            if (i > largest) {
                second = largest;
                largest = i;
            }

        System.out.println(second + "");
    }
}
