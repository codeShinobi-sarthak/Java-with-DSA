package Intermediate;

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String source, String helper, String destination){
        if (n == 1){
            System.out.println("Disk " + n + " move from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, "Src", "Des", "Help");
        System.out.println("Disk " + n + " move from " + source + " to " + destination);
        towerOfHanoi(n-1, "Help", "Src", "Des");
    }

    public static void main(String[] args) {
        int n = 2;
        towerOfHanoi(n, "Src","Help","Des");
    }
}
