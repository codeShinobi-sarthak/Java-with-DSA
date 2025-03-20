public class InfiniteArray {
//    public static void infiniteSortedArray(int[] arr, int target) {
//        int start = 0;
//        int end = 1;
//        boolean bool = false;
//
//        do {
//            if (arr[end] > target) {
//                while (start <= end) {
//                    int mid = (start + end) / 2;
//
//                    if (arr[mid] == target){
//                        bool = true;
//                        System.out.println(mid);
//                        break;
//                    }
//
//                    if (arr[mid] > arr[start]) {
//                        start = mid;
//                    } else end = mid;
//
//                }
//            } else {
//                start = end;
//                end = 2 * end;
//            }
//        } while (!bool);
//    }


    //  -------------------------------- more readable code ------------------------------------
    public static void searchInfiniteArray(int[] arr, int target, int start, int end) {
        boolean bool = false;

        while (!bool) {
            if (target > arr[end]) {
                start = end + 1;
                end = (2 * end) + 1;
            } else {
                int search = binarySearch(arr, target, start, end);
                System.out.println(search);
                break;
            }
        }
    }

    public static int searchInfiniteArray2(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            int temp = end + 1;

            end = end + (end-start + 1)*2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) {
                start = mid + 1;
            } else end = mid - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 11, 17, 19, 23, 38, 30, 40, 51};
        int target = 17;

//        infiniteSortedArray(arr, target);

//        searchInfiniteArray(arr, target, 0, 1);

        System.out.println(searchInfiniteArray2(arr, target));
    }
}
