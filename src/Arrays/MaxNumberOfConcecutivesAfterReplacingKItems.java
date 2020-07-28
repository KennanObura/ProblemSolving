package Arrays;

import java.util.Arrays;

public class MaxNumberOfConcecutivesAfterReplacingKItems {
    public static void main(String[] args) {

        int[] books = {1, 1, 3, 4, 3, 3, 4};
        int[] books1 = {4, 5, 5, 4, 2, 2, 4};
        int[] books3 = {6,2,3,3,2,6};
        System.out.println(solutionB(books, 2));
    }



    private static int solutionB(int[] A, int K){
        return solutionB(A, K, 0, 0);
    }

//    o(n^2)
    private static int solutionB(int[] A, int K, int index, int max){
        if(index >= A.length) return max;

        int [] temp = new int[A.length];
        System.arraycopy(A, 0, temp, 0, A.length);

        int start = index+1;
        int counter = K;

        while(start < A.length && A[index] == A[start])
            start++;


        if(start >= A.length) return max;

        while (start < A.length && counter-- > 0)
            temp[start++] = A[index];

        System.out.println("start" +start);

        System.out.println(Arrays.toString(temp));

        int concecutives = 0;
        start = index+1;
        while (start < A.length && temp[index] == temp[start++])
            concecutives++;




        start = index;
        while (start > -1 && temp[index] == temp[start]) {
            concecutives++;
            start--;
        }
        System.out.println("cons" + concecutives);


        return solutionB(A, K, index+1, Math.max(max, concecutives));
    }

    private static int solution(int[] A, int K) {

        if (A.length == 0) return 0;

        boolean all_same = true;

        for (int i = 0; i < A.length-1; i++)
            if (A[i] != A[i + 1]){
                all_same = false;
                break;
            }

        if (all_same)
            return A.length;

        int max_books = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            int k_units = K;
            int counter = 1;
            int j = i;
            while ((j + 1 < A.length && A[j] == A[j + 1]) || (j + 1 < A.length && A[j] != A[j + 1] && k_units > 0)) {

                if (A[i] != A[j + 1] && A[j] != A[j + 1]) {
                    k_units--;
                }

                counter++;
                System.out.println(A[j] + ", " + A[j + 1] + "   >>" + counter + " --" + k_units);
                j++;
            }

            max_books = Math.max(counter, max_books);
        }
        return max_books;
    }
}
