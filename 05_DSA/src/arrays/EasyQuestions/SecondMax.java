package EasyQuestions;

public class SecondMax {

//    my solution at first
//    public static int maxElement(int[] array) {
//        int max = Integer.MIN_VALUE;
//        int secMax = array[0];
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] > max) {
//                max = array[i];
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == max) continue;;
//
//            if (array[i] > secMax) {
//                secMax = array[i];
//            }
//        }
//
//        return secMax;
//    }


//  not my solution at first
    public static int maxElement(int[] array) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secMax = max;
                max = array[i];
            } else if(array[i] > secMax && array[i] != max){
                secMax = array[i];
            }
        }

        return secMax;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, 2, 34, 33, 1};

        System.out.println("Maximum element in array is: " + maxElement(array));
    }
}

