import java.lang.reflect.Array;
import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) {

        int hash = 0;
        String key = "Dan";
        System.out.println(hash(key));

        String transaction = "Allow me to introduce myself";
        String[] a = transaction.split("\\s+");

        System.out.println(Arrays.toString(a));

    }

    private static int hash(String key){
        return (key.hashCode() & 0x7fffffff) % 99;
    }

}
