package Beginner;// fibonacci sequence
// 0 1 1 2 3 5 8 ........

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(0);
        System.out.println(1);
        FibonacciSequence(0, 1, 10);
    }

    private static void FibonacciSequence(int firstNum, int secondNum, int n) {
        if(n == 2){
            return;
        }

        int nextNum = firstNum + secondNum;
        System.out.println(nextNum);
        FibonacciSequence(secondNum, nextNum, n-1);
    }
}
