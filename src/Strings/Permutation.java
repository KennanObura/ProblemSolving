package Strings;

public class Permutation {
    public static void main(String[] args) {
//        permutate("ken", "");

        String s = "ABC";
        StringBuilder stringBuilder = new StringBuilder(s);

        permuteSolutionTwo(stringBuilder, s.length(), 0 );
    }

    private void permutate(String string){

    }

    private static void permutate(String string, String result){
        if(string.length() == 0) {
            System.out.println(result);
            return;
        }


        for (int i = 0; i < string.length(); i++){
            String temp = string.substring(0, i)+string.substring(i+1);
            permutate(temp, result+ string.charAt(i));
        }

    }



    private static void permuteSolutionTwo(StringBuilder string, int length, int index){
        if(index == length-1) {
            System.out.println(string);
            return;
        }

        for (int i = 0; i < length ; i++) {

            swap(string, index, i);

            permuteSolutionTwo(string, length, index+1);

            swap(string, index, i);
        }
    }

    private static void swap(StringBuilder string, int i, int j){
        char temp = string.charAt(i);
        string.setCharAt(i, string.charAt(j));
        string.setCharAt(j, temp);
    }
}
