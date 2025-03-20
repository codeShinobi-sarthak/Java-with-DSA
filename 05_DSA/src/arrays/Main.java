import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        type[] arrayName = new type[size];

//        first way creating array
        int[] marks = new int[]{12, 23, 45, 56, 72};

        System.out.println(marks.length);
        System.out.println(marks[2]);


//        second way creating array
        String[] names;
        names = new String[]{"sarth", "sarthak", "sarthu"};

        System.out.println(names.length);
        System.out.println(names[2]);

//---------------------------------------------------------------------------------------
//        random array
        int[] firstRandomArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstRandomArray));
        Arrays.sort(firstRandomArray);
        System.out.println(Arrays.toString(firstRandomArray) + '\n');

        int[] secondRandomArray = getRandomArray(10);
        System.out.println(Arrays.toString(secondRandomArray));
        Arrays.fill(secondRandomArray,1);
        System.out.println(Arrays.toString(secondRandomArray) + "\n");

        int[] thirdRandomArray = Arrays.copyOf(firstRandomArray,5);
        System.out.println(Arrays.toString(thirdRandomArray) + "\n");

//-------------------------------------------------------------------------------------------
//        search like binary sarch

        String[] sArray = new String[]{"sarthak", "rajul", "mom", "papa"};
        Arrays.sort(sArray);
//      sorting the elements is necessary as binary search works on sorted array
        if (Arrays.binarySearch(sArray, "mom") >= 0){
            System.out.println("mom found");
        }


    }

//    generating random array
    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}