package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestValueThatIsNotInArray {
    public static void main(String[] args) {

        int[] test = {1,1, 8};
        System.out.println(solution(test));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();

        for (int i : A)
            if (i > 0) set.add(i);

        for (int i = 1; i <= A.length + 1; i++)
            if (!set.contains(i))
                return i;


        return -1;

    }
}
