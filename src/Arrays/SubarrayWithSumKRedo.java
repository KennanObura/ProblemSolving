package Arrays;

public class SubarrayWithSumKRedo {
    public static void main(String[] args) {
        int[] array = {66, 12, 14, 22, 19};
        find(array, 55);


    }

    private static void find(int[] nums, int K) {
        int sum = 0;
        int low = 0;
        int high = -1;

        for (int i = 0; i <= nums.length; i++) {
            while (sum > K) sum -= nums[low++];

            if (sum == K) {
                high = i;
                break;
            }
            sum += nums[i];
        }

        if (high != -1)
            for (int i = low; i < high; i++)
                System.out.println(nums[i]);

    }


}
