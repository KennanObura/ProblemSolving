package JustLeetCode;

import java.util.HashMap;

public class CollatzConjectureMaxSteps {
    public static void main(String[] args) {

        System.out.println(maxNumberOfSteps(7) + " ");
    }

    private static int maxNumberOfSteps(int num) {
        int max_steps = 0;
//        for (int i = 1; i <= num; i++)
//            max_steps = Math.max(max_steps, getSteps(i));


        /*
         *For dynamic call
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= num; i++)
            max_steps = Math.max(max_steps, getStepsDynamic(i, map));

        return max_steps;
    }

    private static int getSteps(int num) {
        if (num == 1) return 0;
        if (num % 2 == 0) return getSteps(num / 2) + 1;
        else return getSteps(num * 3 + 1) + 1;
    }

    private static int getStepsDynamic(int num, HashMap<Integer, Integer> map) {
        if (num == 1) return 0;

        if (map.containsKey(num))
            return map.get(num);

        if (num % 2 == 0) {
            int step = getStepsDynamic(num/2, map)+1;
            map.put(num, step);
            return step;
        } else {
            int steps = getStepsDynamic(num * 3 + 1, map) + 1;
            map.put(num, steps);
            return steps;
        }

    }
}
