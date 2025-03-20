package binarySearch;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(searchMatrix(arr, 22));
    }


    //    better way
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }


//not so effective
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int left = 0;
//        int right = matrix.length - 1;
//
//        while (right >= left) {
//            int mid = (left + right) / 2;
//
//            if (matrix[mid][0] <= target && matrix[mid][3] >= target) {
//                return searchArray(matrix[mid], target);
//            } else if (matrix[mid][0] > target) {
//                right = mid - 1;
//            } else left = mid + 1;
//        }
//        return false;
//    }
//
//    private static boolean searchArray(int[] array, int target) {
//        System.out.println(Arrays.toString(array));
//        int left = 0;
//        int right = array.length - 1;
//
//        while (right >= left) {
//            int mid = left + right / 2;
//
//            if (array[mid] == target) {
//                return true;
//            }
//
//            if (array[mid] > target) {
//                right = mid - 1;
//            } else left = mid + 1;
//        }
//        return false;
//    }
}
