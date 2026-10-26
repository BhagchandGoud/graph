import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int curr[] : edges) {
            int u = curr[0];
            int v = curr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[n];

        q.add(source);
        isVisited[source] = true;

        while (!q.isEmpty()) {
            int m = q.size();

            while (m-- > 0) {
                int curr = q.poll();

                if (curr == destination) {
                    return true;
                }

                for (int padosi : adj.get(curr)) {

                    if (!isVisited[padosi]) {
                        isVisited[padosi] = true;
                        q.add(padosi);
                    }
                }
            }
        }
        return false;
    }
}
