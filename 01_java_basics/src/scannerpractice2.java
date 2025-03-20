import java.util.Scanner;

public class scannerpractice2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double max = 0;
        double min = 0;
        int loopCount = 0;

        while (true){
            System.out.println("Enter a number (to quit enter character): ");
            String input = scanner.nextLine();

            try{
                double num = Double.parseDouble(input);
                if(loopCount == 0 || num < min){
                    min = num;
                }
                if (loopCount == 0 ||num > max){
                    max = num;
                }
                loopCount++;
            } catch (NumberFormatException nfe){
                break;
            }
            System.out.println("minimum number entered: " + min);
            System.out.println("maximum number entered: " + max);
        }
    }
}
