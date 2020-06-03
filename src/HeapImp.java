import java.util.Arrays;

public class HeapImp {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(8);
        int[] nums = {1,3,15,6,17,9,12,34};
        for (int i: nums)
            minHeap.add(i);
        minHeap.print();

//        System.out.println("Removing an item");
//        minHeap.remove();
//        minHeap.print();

    }
}

class Heap {
    int capacity;
    int size;
    int[] children;

    Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.children = new int[capacity];
    }
}

class MinHeap {
    Heap heap;

    MinHeap(int capacity){
        this.heap = new Heap(capacity);
    }
    void add(int data){
        heap = this.add(heap, data);
    }

    void remove(){
        heap = this.remove(heap);
    }

    void print(){
        System.out.println(Arrays.toString(heap.children));
    }

    private Heap add(Heap heap, int data) {
        if (isCapacityReached(heap))
            throw new RuntimeException("Capacity is reached");
        heap.children[heap.size] = data;
        heap.size++;
        return heapifyUp(heap);
    }

    private Heap remove(Heap root) {
        if (root.size == 1) {
            root.children[0] = 0;
            root.size--;
            return root;
        }
        root.children[0] = root.children[root.size - 1];
        root.children[root.size - 1] = 0;
        root.size--;
        return heapifyDown(root);
    }

    private Heap heapifyDown(Heap root) {
        int parentIndex = 0;
        int leftChildIndex = getLeftChild(parentIndex);
        int rightChildIndex = getRightChild(parentIndex);
        int maxIndex = getMinIndex(root, leftChildIndex, rightChildIndex);

        while (maxIndex < root.size && root.children[parentIndex] > root.children[maxIndex]) {
            swap(root, parentIndex, maxIndex);
            parentIndex = maxIndex;
            leftChildIndex = getLeftChild(parentIndex);
            rightChildIndex = getRightChild(parentIndex);
            maxIndex = getMinIndex(root, leftChildIndex, rightChildIndex);
        }
        return root;
    }

    private int getMinIndex(Heap root, int leftChildIndex, int rightChildIndex) {
        if (leftChildIndex < root.size && rightChildIndex < root.size)
            return (root.children[leftChildIndex] < root.children[rightChildIndex] ? leftChildIndex : rightChildIndex);
        return leftChildIndex;
    }

    private Heap heapifyUp(Heap heap) {
        int childIndex = heap.size - 1;
        int parentIndex = getParent(childIndex);
        while (parentIndex > -1 && heap.children[childIndex] < heap.children[parentIndex]) {
            swap(heap, parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = getParent(childIndex);
        }
        return heap;
    }


    private void swap(Heap heap, int parentIndex, int childIndex) {
        int temp = heap.children[parentIndex];
        heap.children[parentIndex] = heap.children[childIndex];
        heap.children[childIndex] = temp;
    }


    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private boolean isCapacityReached(Heap heap) {
        return (heap.capacity == heap.size);
    }
}
