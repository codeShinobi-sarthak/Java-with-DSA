public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {2, 4};
        System.out.println(largestRectangleArea(heights));
    }

//    ! pending---------------



//?    didnt work for all test cases
    public static int largestRectangleArea(int[] heights) {
//        Stack<Integer> height = new Stack<>();
//        Stack<Integer> index = new Stack<>();
        int len = heights.length;
        int maxArea = 0;

        for (int i = 0; i < len; i++) {
            int right = i;
            int left = i;

            while (left > 0 && heights[left] >= heights[i]) {
                left--;
            }

            while (right < (len - 1) && heights[right] >= heights[i]) {
                right++;
            }

            int area = (right - left) * heights[i];
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
