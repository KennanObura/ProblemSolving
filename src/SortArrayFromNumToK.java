import java.lang.Math;
import java.util.Arrays;

public class SortArrayFromNumToK {
    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 12, 56, 8};
        Sort sort = new Sort(nums);
        sort.calculate();
    }

    static class Sort {
        int[] nums;

        Sort(int[] nums) {
            this.nums = nums;
        }

        void calculate() {
            calculate(6, 3);
            System.out.println(Arrays.toString(nums));
        }

        void calculate(int element1, int element2) {
            int index_1 = findIndex(element1);
            int index_2 = findIndex(element2);
            if (index_1 == -1 || index_2 == -1) {
                System.out.println("Nums out of bond");
                return;
            }


            int start = Math.min(index_1, index_2);
            int end = Math.max(index_1, index_2);


            for (int i = start; i < end; i++) {
                for (int j = start; j < end - 1; j++)
                    if (nums[j] > nums[j + 1]) swap(j, j + 1);
            }
            return;
        }

        private void swap(int i, int j) {
            System.out.println("Swaping " + nums[i] + " with " + nums[j]);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private int findIndex(int k) {
            int index = -1;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == k) {
                    index = i;
                    break;
                }
            System.out.println("index at :" + index);
            return index;
        }
    }
}
