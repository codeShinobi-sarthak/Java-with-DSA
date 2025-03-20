import java.util.Scanner;

public class UpdateBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 or 0 : ");
        int update = scanner.nextInt();

        int n = 9;
        int updateBitPos = 4;


        if (update == 1) {
            int bitMask = 1 << (updateBitPos - 1);
            System.out.println(bitMask|n);
        } else if (update == 0) {
            int notBitMask = ~(1 << (updateBitPos - 1));
            System.out.println(notBitMask&n);
        }
    }
}
