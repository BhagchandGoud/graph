import java.util.*;

public class LeetCode_1443_Using_DFS {

    int dfs(ArrayList<ArrayList<Integer>> adj, List<Boolean> hasApple, int i, int parent) {
        int time = 0;

        for (int child : adj.get(i)) {
            if (parent == child)
                continue;

            int time_from_child = dfs(adj, hasApple, child, i);

            if (time_from_child > 0 || hasApple.get(child)) {
                time += time_from_child + 2;
            }
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(adj, hasApple, 0, -1);
    }
}