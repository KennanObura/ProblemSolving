package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {
    public static void main(String[] args) {

        int[] arrA = { 25, 12, 14, 22, 19};
        int[] arr2 = {25, 12, -14, 22, -19, 15, -10, 23};

        int K = 55;

        solution(arrA, K);

        solutionWithNegatives(arr2, -11);

    }

    private static void solution(int[] arr, int K) {

        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            while (sum > K) {
                sum -= arr[start++];
            }
            if(sum == K) {
                end = i;
                break;
            }
        }

        for (int i = start; i <=end ; i++)
            System.out.println(arr[i]);
    }



    private static void solutionWithNegatives(int[] arr, int K) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == K){
                end = i;
                break;
            }

            if(map.containsKey(sum-K)){
                start = map.get(sum-K)+1;
                end = i;
                break;
            }

            map.put(sum, i);

        }

        System.out.println("================");
        for (int i = start; i <=end ; i++)
            System.out.println(arr[i]);
    }
}
