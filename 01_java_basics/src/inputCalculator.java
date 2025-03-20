
// type casting topic ka revision
//exception handling
//user input

import java.util.Scanner;

public class inputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        long avg = 0;

        while (true) {
            try {
                String input = scanner.nextLine();
                int num = Integer.parseInt(input);
                sum += num;
                count++;
            } catch (Exception e) {
                avg = Math.round((double) sum / count);
                System.out.println("SUM = " + sum + " AVG = " + avg);
                break;
            }
        }
    }
}

