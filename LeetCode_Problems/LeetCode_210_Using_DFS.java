import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_210_Using_DFS {
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int in_degree[] = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u); // v --- > u
            in_degree[u]++;
        }

       

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }


    

        int result[] = new int[numCourses];
        int index = 0;
        

        while (!q.isEmpty()) {
            int curr = q.poll();

            result[index++] = curr;

            for (int padosi : adj.get(curr)) {
                in_degree[padosi]--;
                if (in_degree[padosi] == 0) {
                    q.add(padosi);
                }
            }
        }

        if (index == numCourses) {
            return result;
        }
        return new int[0];
    }
}
