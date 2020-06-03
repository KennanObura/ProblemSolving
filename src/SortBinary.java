import java.util.Arrays;

public class SortBinary {
    public static void main(String[] args) {
        int[] bin = {1, 1, 0, 0, 1, 0, 1, 0, 1};
        int[] bin2 = {1, 1, 0, 0, 1, 0, 1, 0};
        Pointer pointer = new Pointer(bin);
        System.out.println("Using pointer");
        pointer.pointer();
        pointer.print();

        Pointer counter = new Pointer(bin2);
        System.out.println("Using counter");
        counter.counter();
        counter.print();
    }

    private static class Pointer {

        int[] binary;

        Pointer(int[] binary) {
            this.binary = binary;
        }

        void pointer() {
            pointer(binary);
        }

        void counter(){
            counter(binary);
        }

        void print() {
            System.out.println(Arrays.toString(binary));
        }

        private void pointer(int[] binary) {
            int start = 0;
            int end = binary.length - 1;

            while (end > start) {
                if (binary[start] == 1 && binary[end] == 0) {
                    swap(binary, start, end);
                    start++;
                    end--;
                }

                if (binary[start] == 0) start++;
                if (binary[end] == 1) end--;
            }
        }

        private void swap(int[] binary, int start, int end) {
            int temp = binary[start];
            binary[start] = binary[end];
            binary[end] = temp;
        }
        private void counter(int[] binary) {
            int ones = 0;
            int zeros = 0;
            for (int i : binary) if (i == 0) zeros++;

            for (int i = 0; i < zeros; i++) binary[i] = 0;
            for (int i = zeros; i < binary.length; i++) binary[i] = 1;
        }

    }

}
