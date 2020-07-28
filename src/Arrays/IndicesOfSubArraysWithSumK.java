package Arrays;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IndicesOfSubArraysWithSumK {
    static private Set<Pair<Integer, Integer>> result;
    public static void main(String[] args) {
        result = new HashSet<>();
        int[] arr = {2, 3, 6, 4, 9, 0, 11};
        int K = 9;

        solve(arr, K);

        for (Pair<Integer, Integer> pair: result)
            System.out.println(pair.getFirst() + " ," + pair.getSecond());
    }

    private static void solve(int [] nums, int K){
        solve(nums, 0, 0, 0, K);
    }

    private static void solve(int[] nums, int index, int start, int sum, int K) {
        if(index == nums.length) return;

        if(nums[index] == K)
            result.add(new Pair<>(index, index));

        while (sum > K)
            sum -= nums[start++];

        if(sum == K)
            result.add(new Pair<>(start, index-1));

        solve(nums, index+1, start, sum+nums[index], K);
    }
}
