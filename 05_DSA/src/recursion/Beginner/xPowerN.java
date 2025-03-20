package Beginner;//Print x^n
// stack heigth is the number of elements present in the Stack


import java.util.Stack;

public class xPowerN {
    public static void main(String[] args) {
//        (with stack height = n)
//        printPower(5, 6, 1);
//        printPower2(2, 6);

//        (with stack height = logn)
        System.out.println(printPower4(2, 6));;
    }

//    (with stack height = n)
    public static void printPower(int x, int n, int result) {
        if (n == 0){
            System.out.println("The stack height is: " + Thread.currentThread().getStackTrace().length);
            System.out.println(result);
            return;
        }
        result = result*x;
        printPower(x,n-1, result);
    }

    public static int printPower2(int x, int n) {
        if(n == 0) {
            System.out.println("The stack height is: " + Thread.currentThread().getStackTrace().length);
            return 1;
        }
        if(x == 0) {
            System.out.println("The stack height is: " + Thread.currentThread().getStackTrace().length);
            return 0;
        }

        int x_ = printPower2(x, n-1);
        int xn = x * x_;
        return xn;
    }


//    (with stack height = logn)
    public static int printPower4(int x, int n) {
        if(n == 0) {
            return 1;
        }

        if(n % 2 == 0) {
            return printPower4(x, n/2) * printPower4(x, n/2);
        }
        else {
            return x * printPower4(x, n/2) * printPower4(x, n/2);
        }
    }
}
