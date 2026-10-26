import java.util.*;

public class LeetCode_1466_Using_DFS {
    int count = 0;

    void dfs(ArrayList<ArrayList<int[]>> adj, int curr, int parent) {

        for (int[] p : adj.get(curr)) {
            int v = p[0];
            if (v != parent) {
                int check = p[1];

                if (check == 1) {
                    count++;
                }
                dfs(adj, v, curr);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            adj.get(u).add(new int[] { v, 1 }); // storing original direction node
            adj.get(v).add(new int[] { u, 0 }); // storing duplicate direction node
        }

        dfs(adj, 0, -1);

        return count;
    }
}