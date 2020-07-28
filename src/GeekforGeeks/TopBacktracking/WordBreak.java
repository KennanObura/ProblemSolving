package GeekforGeeks.TopBacktracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {

        String string = "iloveicecreamandmango";
        solve(string);
    }

    private static class Dictionary {

        private  static final Set<String> dictionary = new HashSet<>();

        private static final String [] words = {"mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream"};

        private static void buildDictionary(){
            dictionary.addAll(Arrays.asList(words));
        }

         static boolean contains(String string){
            return dictionary.contains(string);
        }
    }

    private static void solve(String string){
        Dictionary.buildDictionary();
        solve(string, "");
    }

    private static void solve(String string, String result){
        if(string.length() == 0){
            System.out.println(result);
            return;
        }


        for (int i = 1; i <= string.length() ; i++) {
            String prefix = string.substring(0, i);

            if(Dictionary.contains(prefix)) {
                solve(string.substring(i), result + " " + prefix );
            }
        }
    }
}
