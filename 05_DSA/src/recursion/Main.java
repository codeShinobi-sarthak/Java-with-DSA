public class Main {
    public static void main(String[] args) {
//        print sum of n natural numbers
        sum(1, 5, 0);
    }

    //        print sum of n natural numbers
    public static void sum(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        sum(i+1, n, sum);
    }
}