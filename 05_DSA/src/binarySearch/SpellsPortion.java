import java.util.Arrays;

public class SpellsPortion {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int i = 0;

        while (i < spells.length) {
            int start = 0;
            int end = potions.length - 1;

            while (end >= start) {
                int mid = (end + start) / 2;

                if ((long) spells[i] * potions[mid] >= success) {
                    end = mid - 1;
                } else start = mid + 1;
            }
            ans[i] = potions.length - start;
            i++;
        }
        return ans;
    }
}
