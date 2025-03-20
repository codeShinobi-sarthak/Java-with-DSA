package mediumQestion;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 0, 0, 2};
        sortColors(arr);
    }

    public static void sortColors(int[] nums) {
        int rightBond = nums.length - 1;

        for (int i = 0; i <= rightBond; i++) {
            if (nums[rightBond] == 2) {
                rightBond--;
                i--;
                continue;
            }
            if (nums[i] == 2) {
                nums[i] = nums[rightBond];
                nums[rightBond] = 2;
                rightBond--;
            }
        }

        for (int j = 0; j <= rightBond; j++) {
            if (nums[rightBond] == 1) {
                rightBond--;
                j--;
                continue;
            }
            if (nums[j] == 1) {
                nums[j] = nums[rightBond];
                nums[rightBond] = 1;
                rightBond--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
