public class SetBit {
    public static void main(String[] args) {
        int n = 9;
        int setBit = 2;

        int bitMask = 1<<(setBit-1);

        System.out.println(bitMask|n);
    }
}
