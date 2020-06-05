package JustLeetCode;

public class MinNumberOfOperations {
    public static void main(String[] args) {
        System.out.println(" " + integerReplacement(5));
    }

    private static int integerReplacement(int num){
        return  getOperations(num);

    }

    private static int getOperations(int num) {
        if(num == 1) return 0;
        if(num%2 == 0) return getOperations(num/2)+1;
        return Math.min(getOperations(num-1), getOperations(num+1))+1;
    }


}
