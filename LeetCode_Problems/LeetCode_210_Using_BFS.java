import java.util.ArrayList;
import java.util.Stack;

public class LeetCode_210_Using_BFS {
    static boolean has_cycle;

    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean is_visited[], boolean is_in_recursion[],
            Stack<Integer>st) {
        is_visited[u] = true;
        is_in_recursion[u] = true;

        for (int padosi : adj.get(u)) {

            if (is_in_recursion[padosi] == true) {
                has_cycle = true;
                return;
            }
            if (!is_visited[padosi]) {
                
                dfs(adj, padosi, is_visited, is_in_recursion , st);
            }
        }

        st.push(u);

        is_in_recursion[u] = false;
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {

        has_cycle = false;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        boolean is_visited[] = new boolean[numCourses];

        boolean is_in_recursion[] = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u); // v --- > u

        }

        for (int i = 0; i < numCourses; i++) {
            if (!is_visited[i]) {
                dfs(adj, i, is_visited, is_in_recursion, st);
            }
        }

        if(has_cycle == true){
            return new int[0];
        }

        int result[] = new int[numCourses];

        int k = 0;

        while (!st.isEmpty()) {
            result[k++] = st.pop();
        }
        return result;

    }
}
