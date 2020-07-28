
import java.lang.*;
import java.lang.Math;

public class FrogJumpingProblem {
    public static void main(String[] args) {

        int[] edges = {2,3,8,9};
        System.out.println(solve(edges));
    }

    private static int solve(int [] edges){
        int max_jumps = Integer.MIN_VALUE;

        for (int i = 0; i < edges.length; i++) {


            /**
             * go left while, i-1th elem is equal/more
             *      check left > -1
             *
             *      count ++;
             *
             *
             *  go right while, i+1th elem is equal/more
             *      check right < size
             *      count ++
             */

            int to_left  = i-1;

            while(to_left-1 > -1 && edges[to_left] >= edges[i] && edges[to_left] >= edges[to_left-1]) {
                to_left--;
                System.out.println(edges[to_left]);
            }

            int to_right = i+1;

////            {2,3,1,3,4,2}
            while (to_right+1 < edges.length && edges[to_right] <= edges[to_right+1]){
                to_right++;
            }

            max_jumps = Math.max(max_jumps, (Math.abs(i-to_left) + Math.abs(i+1-to_right)));

        }

        return max_jumps;
    }
}
