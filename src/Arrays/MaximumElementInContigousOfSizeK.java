package Arrays;

/**
 * Given an Array of integers and an Integer k, Find the maximum element of from all the contiguous subarrays of size K.
 *
 * For eg :
 *
 * Input : int[] arr = {2,6,-1,2,4,1,-6,5}
 * int k = 3
 * output : 6,6,4,4,4,5
 * for every subarray of size k, Print its maximum element.
 */
public class MaximumElementInContigousOfSizeK {
    public static void main(String[] args) {

        int[] arr = {2,6,-1,2,4,1,-6,5};
        int k = 3;

        findSlidingWindow(arr, k);
    }

    private static void findNaive(int [] nums, int K){

        for (int i = 0; i < nums.length-K ; i++) {
            int max = nums[i];
            int j = i+1;
            int count = 0;
            while(j <= i+K) {
                max = Math.max(max, nums[j++]);
//                System.out.println("count " + nums[i] + "--" + nums[j]);
            }

            System.out.println(max);
        }
    }


    private static void findSlidingWindow(int [] nums, int K){

      int i = 0;
      int j = 0;
      int max = Integer.MIN_VALUE;
      while (i <= nums.length-K){
          if(j == K){
              i++;
              j = 0;
              System.out.println(max);
              max = Integer.MIN_VALUE;
          }
          max = Math.max(max, nums[i+j]);
          j++;
      }
    }
}
