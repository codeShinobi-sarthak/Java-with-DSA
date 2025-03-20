import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            graph.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if all courses are processed
        if (order.size() == numCourses) {
            return order.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0]; // Cycle detected
        }
    }
}
