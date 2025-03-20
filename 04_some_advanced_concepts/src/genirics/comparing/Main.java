package genirics.comparing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student A = new Student(12, 89.76f);
        Student B = new Student(5, 99.52f);
        Student C = new Student(2, 95.52f);
        Student D = new Student(13, 77.52f);
        Student E = new Student(9, 96.52f);

        System.out.println(A.compareTo(B));

        Student[] list = {A, B, C, D, E};

        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));;
    }
}
