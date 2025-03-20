package Beginner;//factorial of a given number n

public class Factorial {
    public static void main(String[] args) {
        Factorial(5, 1);
    }

    public static void Factorial(int n, int result){
        if (n == 0){
            System.out.println(result);
            return;
        }
        result = n*result;
        Factorial(n-1, result);
    }
}
