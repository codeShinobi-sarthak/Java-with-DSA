public class FindUnique {
    public static void main(String[] args) {
     int[] arr = {2,3, 5, 6, 2, 3, 5};
     int unique = 0;

     for (int n : arr){
         unique ^= n;
     }
        System.out.println(unique);
    }
}
