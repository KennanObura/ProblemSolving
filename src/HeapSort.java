import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {


        Heap heap = new Heap(8);
        heap.add(2);
        heap.add(9);
        heap.add(8);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(12);

        heap.print();
    }

    private static class Heap{
        int [] items;
        int capacity, size;

        Heap(int capacity){
             items = new int[capacity];
            this.size = 0;
            this.capacity = capacity;
        }

        private void add(int data){
            if(capacityReached())
                throw new RuntimeException("Capacity reached");
            items[size] = data;
            size++;
            hipifyUp();
        }

        private void print(){
            System.out.println(Arrays.toString(items));
        }

        private void hipifyUp() {
            int elemIndex = size-1;
            int parentIndex = getParentIndex(elemIndex);

            while (parentIndex > -1 && items[parentIndex] > items[elemIndex]){
                swap(parentIndex, elemIndex);
                elemIndex = parentIndex;
                parentIndex = getParentIndex(elemIndex);
            }
        }


        private void swap(int parentIndex, int elemIndex) {
            int temp = items[parentIndex];
            items[parentIndex] = items[elemIndex];
            items[elemIndex] = temp;
        }

        private int getParentIndex(int index) {
            return (index-1)/2 ;
        }

        private boolean capacityReached() {
            return (size == capacity);
        }


    }
}
