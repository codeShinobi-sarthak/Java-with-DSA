package arrays.mediumQestion;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval[0] > interval[1]) { // Case 1: New interval starts after the current one
                ans.add(interval);
            } else if (newInterval[1] < interval[0]) { // Case 2: New interval ends before the current one
                ans.add(newInterval);
                newInterval = interval; // Update newInterval to be inserted later
            } else { // Case 3: Overlapping intervals, merge them
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        ans.add(newInterval); // Insert the last merged interval
        return ans.toArray(new int[ans.size()][]); // Convert list to array
    }
}
