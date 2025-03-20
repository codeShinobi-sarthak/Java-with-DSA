package genirics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CustomGenArrayList<T> {

    private Object[] data;
    private static final int defaultSize = 10;
    private int size = 0;

    public CustomGenArrayList() {
        this.data = new Object[defaultSize];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }

        data[size++] = num;
    }

    public void add(int index, T num) {
        if (isFull()) {
            resize();
        }

        data[index] = num;
    }

    public T remove() {
        return (T)(data[--size]);
    }

    public void remove(int index) {
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size] = 0;
    }

    private void resize() {
        Object[] temp = new Object[size + 1];

        // * coppying current element into new array
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public T get(int index) {
        return (T)(data[index]);
    }

    public int size() {
        return size;
    }

    public void set(int index, T num) {
        data[index] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
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
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(23);
//        list.add(36);
//        list.remove(0);
//        list.set(2, 44);
//        list.get(2);

//        System.out.println("------------------------------------------------------");

        CustomGenArrayList<Integer> customList = new CustomGenArrayList<>();
        customList.add(16);
        customList.add(1);
        customList.add(10);
        customList.add(3);
        customList.add(19);
        System.out.println(customList);
    }
}
