package mediumQestion;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1 , 4};

        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        int index = 0;
        int innitialPos = 0;
        int firstElement = nums[0];
        int l = nums.length;

        while(firstElement > 0){
            while(innitialPos < l){
                if (innitialPos + nums[innitialPos] < l){
                    innitialPos += nums[innitialPos];
                }else if (innitialPos + nums[innitialPos] > l || nums[innitialPos] == 0){
                    innitialPos = 0;
                    break;
                } else if (innitialPos == l-1) {
                    return true;
                }
            }
            firstElement--;
        }
        return false;
    }
}
