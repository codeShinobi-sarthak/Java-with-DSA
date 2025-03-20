package heaps;

import java.util.ArrayList;

public class Heaps<T extends Comparable> {

    private ArrayList<T> list;

    public Heaps() {
        this.list = new ArrayList<T>();
    }

    //    get the index of parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child of the node at index i
    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    // Get the index of the right child of the node at index i
    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    //swaping two numbers
    private void swap(int x, int y) {
        T temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    // Add a new element to the heap
    public void add(T value) {
        list.add(value);
        heapifyUp(list.size() - 1);
    }

    // Ensure the heap property is maintained after adding a new element
    private void heapifyUp(int i) {
        if (i == 0) return;
        int parentIndex = parent(i);
        if ((int) list.get(i) > (int) list.get(parentIndex)) {
            swap(i, parentIndex);
        }
        heapifyUp(i - 1);

//   ?     iterative method
//        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
//            swap(i, parent(i));
//            i = parent(i);
//        }
    }

    // Remove and return the maximum element from the heap
    public T removeMax() {
        if (list.isEmpty()) throw new IllegalStateException("Heap is Empty");
        T getMax = list.get(0);
        list.set(0, list.remove(list.size() - 1));
        heapifyDown(0);
        return getMax;
    }

    // Ensure the heap property is maintained after removing the maximum element
    private void heapifyDown(int i) {
        int maxIndex = i;

        int left = leftChild(i);
        if (left < list.size() && (int) list.get(left) > (int) list.get(maxIndex)) {
            maxIndex = left;
        }

        int right = rightChild(i);
        if (right < list.size() && (int) list.get(right) > (int) list.get(maxIndex)) {
            maxIndex = right;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    //    check empty heap
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Get the size of the heap
    public int size() {
        return list.size();
    }

}
