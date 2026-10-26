import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Directed_Graph_Cycle {

    boolean solve(int V, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int inDegrees[] = new int[V];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);

            inDegrees[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);

            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int padosi : adj.get(curr)) {
                inDegrees[padosi]--;
                if (inDegrees[padosi] == 0) {
                    q.add(padosi);
                }
            }
        }
        if (count == V) {
            return false;
        }
        return true;
    }

    public boolean isCyclic(int V, int[][] edges) {
        return solve(V, edges);
    }

}
