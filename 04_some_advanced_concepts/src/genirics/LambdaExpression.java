package genirics;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaExpression {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

        System.out.print("original array : ");
        arr.forEach(n -> System.out.print(n + ", "));


//        arr.forEach((item) -> System.out.println(item * 2));
        System.out.print("\narray after mofifying : ");
        Consumer<Integer> fun = (item) -> System.out.print(item * 2 + ", ");
        arr.forEach(fun);

        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;

        System.out.println("\n\n------------------Lambda operations-----------------------");
        LambdaExpression myCalculator = new LambdaExpression();
        System.out.println(myCalculator.operate(5, 3, sum));
        System.out.println(myCalculator.operate(5, 3, prod));
        System.out.println(myCalculator.operate(5, 3, sub));
    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}

