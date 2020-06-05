package JustLeetCode;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MargeIntervals {
    public static void main(String[] args) {

        int[][] intes = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}, {16,17}, {16, 20}
        };

        marge(intes);
    }

    private  enum Overlap {
        NO_OVERLAP, PARTIAL, COMPLETE
    }

    private static void marge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] peek = stack.peek();
            Overlap overlap = getOverlap(peek, intervals[i]);

            if (overlap == Overlap.COMPLETE) continue;
            if (overlap == Overlap.PARTIAL) {
                stack.pop();
                peek[1] = intervals[i][1];
                stack.push(peek);
            }

            if (overlap == Overlap.NO_OVERLAP)
                stack.push(intervals[i]);
        }

//        ArrayList<>
        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.pop()) + " -");
        }

    }

    private static Overlap getOverlap(int[] peek, int[] interval) {
        if (peek[1] > interval[0] && interval[1] > peek[1])
            return Overlap.PARTIAL;
        if (peek[1] > interval[0] && peek[1] > interval[1])
            return Overlap.COMPLETE;
        return Overlap.NO_OVERLAP;
    }

}
