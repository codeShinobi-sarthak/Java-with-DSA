package EasyQuestions;

public class MissingNumber {

    public  static int missingNumber(int[] array, int n) {
        int sum = (n+1)*(n+1+1)/2;
        int arrSum = 0;
            for (int i = 0; i < array.length; i++){
                arrSum += array[i];
            }
        System.out.println(sum);
        System.out.println(arrSum);
            return sum-arrSum;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 5};

        System.out.println("Missing No. in array is: " + missingNumber(array, array.length));
    }

}
