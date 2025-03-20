public class ValidSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(49));
        System.out.println(isPerfectSquare(15));
        System.out.println(isPerfectSquare(100));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;

        while (right >= left) {
            int mid = (right + left) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return false;
    }
}
