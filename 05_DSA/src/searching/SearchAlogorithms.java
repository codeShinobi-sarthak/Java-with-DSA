package searching;

public class SearchAlogorithms {

    //    linear search algorithm
    public static void linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found in array");
    }

    //    binary search algorithm
    public static void binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                System.out.println("Element found at index " + mid);
                return;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Element not found in array");
    }

    //    using recursive algorithm
    public static int binarySearch2(int[] array, int target, int left, int right) {

        if (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                return binarySearch2(array, 11, left, mid - 1);
            } else {
                return binarySearch2(array, 11, mid + 1, right);
            }
        }
        return -1;
    }

//    order-agnostic binary search
    public static int orderAgnosticBinarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        boolean ascending = array[start] < array[end];

        while (start<=end) {
            int mid = (start+end) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (ascending){
                if (array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else{
                if (array[mid] > target) {
                    start = mid - 1;
                } else {
                    end = mid + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

//        for linear search
//        int[] array = {19, 32, 73, 45, 48, 5, 16};
//        linearSearch(array, 5);

//        for binary search [works for only sorted arrays]
        int[] sortedArray = {2, 7, 11, 19, 21, 30, 56};

//        binarySearch(sortedArray, 11);

//        for recursive binary search
        int result = binarySearch2(sortedArray, 11, 0, sortedArray.length - 1);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in array");
        }

//    order-agnostic binary search
        int result2 = orderAgnosticBinarySearch(sortedArray, 21);
        System.out.println(result2);
    }
}
