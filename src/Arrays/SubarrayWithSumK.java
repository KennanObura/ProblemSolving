package Arrays;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] array = {25, 12, 14, 22, 19, 15, 10, 23};
        find(array, 55);

        findRecur(array, 55, 0, 0, 0);

    }

    private static void find(int[] nums, int sum) {
        int start = 0;
        int end = -1;
        int sum_so_far = 0;

        for (int i = 0; i < nums.length; i++) {

            while (sum_so_far > sum)
                sum_so_far -= nums[start++];

            if (sum_so_far == sum) {
                end = i;
                break;
            }
            sum_so_far += nums[i];
        }

        if (end != -1)
            for (int i = start; i < end; i++)
                System.out.println(nums[i]);

    }



    private static void findRecur(int[] nums, int K, int sum, int index, int start) {
        if (index >= nums.length) return;

        if (nums[index] == K) {
            System.out.println(nums[index]);
            return;
        }

        while (sum > K) sum -= nums[start++];

        if (sum == K) {
            for (int i = start; i < index; i++)
                System.out.println(nums[i]);
            return;
        }

        findRecur(nums, K, sum + nums[index], index + 1, start);
    }
}
