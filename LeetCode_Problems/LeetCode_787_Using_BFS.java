import java.util.*;

public class LeetCode_787_Using_BFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            adj.get(u).add(new int[] { v, cost });
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0 });

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        int steps = 0;

        while (!q.isEmpty() && steps <= k) {
            int size = q.size();
            int[] temp = cost.clone();
            
            while (size-- > 0) {
                int curr[] = q.poll();
                int node = curr[0];
                int currCost = curr[1];

                for (int edge[] : adj.get(node)) {
                    int next = edge[0];
                    int price = edge[1];

                    if (temp[next] > currCost + price) {
                        temp[next] = currCost + price;
                        q.add(new int[] { next, currCost + price });
                    }
                }
            }
            cost = temp;
            steps++;
        }

        if (cost[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return cost[dst];
    }
}