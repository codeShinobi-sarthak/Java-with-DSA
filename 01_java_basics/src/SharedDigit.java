public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(21, 41));
        System.out.println(hasSharedDigit(56, 21));

    }
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 > 99 || num1 < 10 || num2 > 99 || num2 < 10) {
            return false;
        }

        int d1 = num1 % 10;
        int d2 = num2 % 10;
        int d3 = num1 / 10;
        int d4 = num2 / 10;

        return ((d1 == d2) || (d2 == d3) || (d3 == d4) || (d4 == d1));
    }
}
