import java.util.*;

public class LeetCode_2492_Using_BFS {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];

            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }

        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[n + 1];
        q.add(1);
        isVisited[1] = true;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {

                int curr_node = q.poll();

                for (int padosi[] : adj.get(curr_node)) {
                    min = Math.min(padosi[1], min);
                    
                    if (!isVisited[padosi[0]]) {
                        q.add(padosi[0]);
                        isVisited[padosi[0]] = true;
                    }
                }
            }
        }
        return min;
    }
}