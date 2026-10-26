import java.util.*;

public class LeetCode_2316_Using_BFS {
    public long countPairs(int n, int[][] edges) {

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

        long count = 0;
        long remaining = n;
        boolean isVisited[] = new boolean[n + 1];

        for (int start = 0; start < n; start++) {
            if (!isVisited[start]) {
                Queue<Integer> q = new LinkedList<>();

                q.add(start);
                isVisited[start] = true;
                long size = 0;

                while (!q.isEmpty()) {

                    int curr = q.poll();
                    size++;

                    for (int padosi : adj.get(curr)) {
                        if (!isVisited[padosi]) {
                            isVisited[padosi] = true;
                            q.add(padosi);
                        }
                    }

                }
                remaining -= size;
                count += size * remaining;
            }
        }
        return count;
    }
}