public class RotationCount {

    //    linear search (brute force)
    public static int CountRotations(int[] rotatedArr) {
        int i = 0;
        while (i <= rotatedArr.length) {
            if (rotatedArr[i] > rotatedArr[i + 1]) return i + 1;
            i++;
        }
        return i;
    }

    //    using binary Search
    public static int CountRotations2(int[] rotatedArr) {
        int start = 0;
        int end = rotatedArr.length-1;

        while(start < end){
            if(rotatedArr[end] >= rotatedArr[start]) return start;
            int mid = start + (end - start)/2;
            if(rotatedArr[mid]>rotatedArr[end]){
                start = mid +1;
            }else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] rotatedArr = {15, 18, 2, 3, 6, 12};

        System.out.println("Using Linear Search : "  + CountRotations(rotatedArr));

        System.out.println(CountRotations2(rotatedArr));

    }
}
