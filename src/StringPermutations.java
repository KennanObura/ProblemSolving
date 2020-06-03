public class StringPermutations {
    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        permutation.printPermutations("ABC");

    }

    static private class Permutation {

        void printPermutations(String string){
            printPermutations(string, "");
        }

        private void printPermutations(String string, String result) {
            if (string.length() == 0) {
                System.out.println(result);
                return;
            }
            for (int i = 0; i < string.length(); i++)
                printPermutations(string.substring(0, i) + string.substring(i + 1), result + string.charAt(i));

        }
    }
}


