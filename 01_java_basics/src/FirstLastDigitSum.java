public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(firstLastDigitSum(8765));
        System.out.println(firstLastDigitSum(-34));
        System.out.println(firstLastDigitSum(4444));
        System.out.println(firstLastDigitSum(0));
    }

    public static int firstLastDigitSum(int number){
        if (number == 0){
            return number;
        } else if (number < 0) {
            return -1;
        }

        int firstDigit = 0;
        int num = number;
        while(num != 0){
            firstDigit = num%10;
            num /= 10;
//            System.out.println(firstDigit);
        }
        return number%10 + firstDigit;
    }
}
