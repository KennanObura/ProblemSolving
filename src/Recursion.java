public class Recursion {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        recurse(6);
    }


    static  void recurse(int i){
        if(i < 1) {
            System.out.println("System count :" + i);
            return;
        }
        System.out.println("System in :" + i);
        recurse(i-1);
    }
}




