public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(454));
//        System.out.println(isPalindrome(1212));
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int num = Math.abs(number);

        while (num != 0) {
            int lastDigit = num % 10;
            reverse = (reverse * 10) + lastDigit;
            num /= 10;
        }
        System.out.println(reverse);
        return reverse == number;

    }

}