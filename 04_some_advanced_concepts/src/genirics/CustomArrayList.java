package genirics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private int defaultSize = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[defaultSize];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }

        data[size++] = num;
    }

    public void add(int index, int num) {
        if (isFull()) {
            resize();
        }

        data[index] = num;
    }

    public int remove() {
        return data[--size];
    }

    public void remove(int index) {
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size] = 0;
    }

    private void resize() {
        int[] temp = new int[size + 1];

        // * coppying current element into new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int num) {
        data[index] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return data[0] == 0;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", defaultSize=" + defaultSize +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
//        list.add(23);
//        list.add(36);
//        list.remove(0);
//        list.set(2, 44);
//        list.get(2);

//        System.out.println("------------------------------------------------------");

        CustomArrayList customList = new CustomArrayList();
        customList.add(16);
        customList.add(1);
        customList.add(10);
        customList.add(3);
        customList.add(19);
        System.out.println(customList.toString());
    }
}
