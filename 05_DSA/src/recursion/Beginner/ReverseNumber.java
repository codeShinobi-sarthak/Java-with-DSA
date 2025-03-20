package Beginner;

public class ReverseNumber {

    static int sum = 0;
    public static void reverseNum(int x){
        if (x == 0) return; // base case

        int digit = x%10;
        sum = sum*10 + digit;

        reverseNum(x/10);
    }

    public static void reverseNum2(int x, int b){
        if (x == 0) return; // base case

        int digit = x%10;
        sum = (int) (sum + Math.pow(10,b)*digit);

        reverseNum2(x/10,b-1);
    }

    public static void main(String[] args) {
        int x = 6737;
//        reverseNum(738);
//        System.out.println(sum);

        reverseNum2(x, Integer.toString(x).length()-1);
        System.out.println(sum);
        
    }
}
