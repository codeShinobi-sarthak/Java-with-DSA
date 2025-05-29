package binarySearch;

public class SingleElementInSortedArray {
//    public static void main(String[] args) {
//        SingleElementInSortedArray solution = new SingleElementInSortedArray();
//        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5};
//        System.out.println(solution.singleNonDuplicate(nums)); // Output: 3
//    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((nums.length - mid) % 2 == 0) {
                left = mid + 1;
            } else right = mid - 1;
        }

        return left;
    }
}
