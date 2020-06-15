public class Arithmetic {
    public static void main(String[] args) {

        Math math = new Math();

        int[] items = {2, 3, 4};
        System.out.println("GCD : " +math.greatestCommonDivisor(items) + "");

//        System.out.println("LCM : " + math.greatestCommonDivisor(items));
    }
}

class Math {


    int greatestCommonDivisor(int[] items) {
        int result = 1;
        for (int i : items)
            result = greatestCommonDivisor(result, i);
        return result;
    }

    int leastCommonMultiple(int[] items) {
        int lcm = 1;
        for (int i : items)
            lcm *= leastCommonMultiple(lcm, i);
        return lcm;
    }

    /**
     * Lcm of two nums a and b is found by dividing multiples (a*b) by their GCD (greatestCommonDivisor(a, b))
     *
     * @return lcm
     */
    private int leastCommonMultiple(int a, int b) {
        return (a * b) / greatestCommonDivisor(a, b);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return greatestCommonDivisor(b, a % b);
    }


}
