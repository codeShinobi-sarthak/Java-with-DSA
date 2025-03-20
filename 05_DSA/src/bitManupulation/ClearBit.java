// clear bit means making the ith position bit to zero
// remember operations in computer are done in binary

public class ClearBit {
    public static void main(String[] args) {
     int n = 9;

     int clearBitPos = 1;   // change the first bit to 0
//     int clearBitPos = 1;  // no change as the bit is 0 only

     int NotBitmask = ~(1<<(clearBitPos-1));
     System.out.println(NotBitmask & n);
    }
}
