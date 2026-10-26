import java.util.*;

class Pair {
    int des;
    int node;

    Pair(int des, int node) {
        this.des = des;
        this.node = node;
    }
}

public class LeetCode_743 {
    static int networkDelayTime(int[][] times, int n, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adj.get(u).add(new Pair(wt, v));
        }

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.des - b.des);

        pq.add(new Pair(0, src)); // destination , source

        for (int i = 0; i < n + 1; i++) {
            res.add(Integer.MAX_VALUE);
        }
        res.set(src, 0);

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();

            int dist = temp.des;
            int node = temp.node;

            for (Pair padosi : adj.get(node)) {
                int wt = padosi.des;
                int adjNode = padosi.node;

                if (dist > res.get(adjNode))
                    continue;
                

                if (dist + wt < res.get(adjNode)) {
                    pq.add(new Pair((dist + wt), adjNode));
                    res.set(adjNode, dist + wt);
                }
            }
        }

        int max = -1;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res.get(i));
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
    public static void main(String[] args) {
        int times[][] = {{2,1,1} , {2,3,1},{3,4,1}};
        int n = 4;
        int src  = 2;

        int ans = networkDelayTime(times , n , src);

        System.out.println(ans);
    }
}