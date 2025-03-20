package cloning;

public class Human implements Cloneable {
    String name;
    int age;
    int[] arr;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr = new int[]{1, 2, 3, 4, 5};
    }

    public Human(Human other) {
        this.name = other.name;
        this.age = other.age;
    }


//    public Object clone() throws CloneNotSupportedException {
//        // this is shallow copy
//        return super.clone();
//    }

    public Object clone() throws CloneNotSupportedException {
        // this is deep copy
        Human twin = (Human)super.clone(); // ! basically shallow copy

        // make a deep copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
