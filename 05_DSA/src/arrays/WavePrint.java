public class WavePrint {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
//        System.out.println(arr.length);

        printWave(arr, arr.length);
    }

    public static void printWave(int[][] arr, int length) {
        for (int i = 0; i < length-1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < length; j++){
                    System.out.print(arr[j][i] + " ");
                }
            } else {
                for (int j = length-1; j >= 0; j--){
                    System.out.print(arr[j][i] + " ");
                }
            }
        }
    }
}
