import java.util.Scanner;

public class scannerPractice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 1;
        double sum = 0;

        while( counter <= 5){
            System.out.println("Enter the #" + counter + " number: ");
            String num = scanner.nextLine();

            try {
//                int number = Integer.parseInt((num);
                double number = Double.parseDouble(num);
                counter++;
                sum += number;
            }catch(NumberFormatException nfe) {
                System.out.println("invalid input");
            }
        }
        System.out.println("the sum of the numbers are: " + sum);
    }













//    public static void main(String[] args) {
//        Scanner number = new Scanner(System.in);
//
//        int num1 = inputNum(1, number);
//        int num2 = inputNum(2, number);
//        int num3 = inputNum(3, number);
//        int num4 = inputNum(4, number);
//        int num5 = inputNum(5, number);
//
//        int sum = num1+num2+num3+num4+num5;
//
//        System.out.println(sum);
//    }
//
//    public static int inputNum(int x, Scanner number) {
//        int num;
//        do {
//            System.out.println("Enter the " + x + " number");
//            num = number.nextInt();
//        } while (num<0);
//        return num;
//    }
}
