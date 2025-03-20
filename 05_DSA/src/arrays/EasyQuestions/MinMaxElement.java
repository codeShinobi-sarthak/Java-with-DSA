package EasyQuestions;

public class MinMaxElement {

    public static int minElement(int[] array) {
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int maxElement(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{59, 12, 67, 56, 89, 78};

        System.out.println("Minimum element in array is: " + minElement(array));
        System.out.println("Maximum element in array is: " + maxElement(array));
    }
}
