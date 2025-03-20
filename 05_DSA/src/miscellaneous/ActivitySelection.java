//Function to find the maximum number of activities that can
//be performed by a single person.

class Activity {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9)
        };

        System.out.println(eraseOverlapIntervals(activities));
    }

    //    both the problems are same the representation is different
//? in first problem start will be [1, 3. 0, 5, 8] and end will be [4, 5, 6, 7, 9]
    public static int activitySelection(int start[], int end[], int n) {
        int count = 0;
        return count;
    }

    public static int eraseOverlapIntervals(Activity[] intervals) {
        int count = 0;
        return count;
    }
}

