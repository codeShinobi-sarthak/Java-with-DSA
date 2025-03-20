package arrays;

public class FirstMissingPos {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int smPov = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            if (smPov == nums[i]) {
                smPov++;
            } else if (smPov > nums[i]) {
                smPov = nums[i];
            }
        }
        return smPov;
    }
}
