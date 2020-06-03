package JustLeetCode;

public class CollatzConjectureMaxSteps {
    public static void main(String[] args) {

        System.out.println(solve(7) + " ");
    }

    public static int solve(int number) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < number; i++) {
            int steps = getSteps(i);
            max = Math.max(max, steps);
        }

        return max;
    }

    private static int getSteps(int i) {
        if (i == 1)
            return 0;
        if (i % 2 == 0)
            return getSteps(i / 2) + 1;
        else
            return getSteps(3 * i + 1) + 1;
    }
}
