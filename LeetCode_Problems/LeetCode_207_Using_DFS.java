
import java.util.*;

public class LeetCode_207_Using_DFS{
    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean is_visited[] , boolean is_in_recursion[]) {
        is_visited[v] = true;
        is_in_recursion[v] = true;

        for (int padosi : adj.get(v)) {
            if (!is_visited[padosi] && dfs(adj, padosi, is_visited , is_in_recursion)) {
                return true;
            }else if(is_in_recursion[padosi] == true){
                return true;
            }
        }
        is_in_recursion[v] = false;
        return false;
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean is_visited[] = new boolean[numCourses];
        boolean is_in_recursion[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            graph.get(v).add(u);
        }

        
        for (int i = 0; i < numCourses; i++) {
            if (!is_visited[i] && dfs(graph, i, is_visited , is_in_recursion)) {
                return false;
            }
        }

        return true;
    }
}