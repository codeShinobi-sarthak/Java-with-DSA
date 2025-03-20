package arrays.SlidingWindow;

public class subArraySizeKWithThreshold {

    public static void main(String[] args) {

        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};

        int ans = numOfSubarrays(arr, 4, 4);
        System.out.println(ans);
    }

//    ! this works but run time is hign
//    public static int numOfSubarrays(int[] arr, int k, int threshold) {
//        int start = 0;
//        int end = k - 1;
//        int count = 0;
//
//        while (end < arr.length) {
//            int sum = 0;
//            for (int i = start; i <= end; i++) {
//                sum += arr[i];
//            }
//            if (sum/k >= threshold) {
//                count++;
//            }
//            start++;
//            end++;
//        }
//        return count;
//    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum = sum + arr[end];

            if (end >= k - 1) {
                if (sum / k >= threshold)
                    count++;
                sum = sum - arr[start];
                start++;
            }
        }
        return count;
    }
}
