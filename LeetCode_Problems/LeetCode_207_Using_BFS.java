import java.util.*;



/**
 * LeetCode_207_Using_BFS
 */
public class LeetCode_207_Using_BFS {
 
    // only detect cycle solve using khan's algorithm
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        // int n = prerequisites.length;
        

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            graph.get(v).add(u); 
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            count++;

            for (int padosi : graph.get(curr)) {
                indegree[padosi]--;
                if (indegree[padosi] == 0) {
                    q.add(padosi);
                }
            }
        }

        
        return count == numCourses;
    }
    
}