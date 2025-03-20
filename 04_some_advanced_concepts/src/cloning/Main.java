package cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human a = new Human("sarthak", 20);
//        Human twin = new Human(a);

        Human twin = (Human) a.clone();
        System.out.println(twin.name);
        System.out.println(twin.age);
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(a.arr));

        System.out.println("---------------------------------------------");

        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(a.arr));


    }
}
