package TutorialHorizon;

import java.util.ArrayList;

public class UniqueCombinationsOfKNumbers {
    public static void main(String[] args) {
        Combinations combinations = new Combinations(2, 5);
        combinations.find();
    }

    private static class Combinations {
        final int K;
        final int N;

        Combinations(int K, int N) {
            this.K = K;
            this.N = N;
        }

        void find() {
            find(K, 0, 0, new ArrayList<>());
        }

        private void find(int k, int currentSum, int index, ArrayList<Integer> result) {
            if (currentSum == N && k == 0) {
                System.out.println(result);
                return;
            }

            for (int i = index; i < 10; i++) {
                result.add(i);
                find(k - 1, currentSum + i, i + 1, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
