import java.util.ArrayList;

public class Bellman_Ford_Algorithm {

    static ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        ArrayList<Integer> dis = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dis.add(100000000);
        }

        dis.set(src, 0);

        for (int i = 1; i <= V - 1; i++) {
            for (int padosi[] : edges) {
                int u = padosi[0];
                int v = padosi[1];
                int wt = padosi[2];

                if (dis.get(u) != 100000000 && dis.get(u) + wt < dis.get(v)) {
                    dis.set(v, (dis.get(u) + wt));
                }
            }
        }

        // Now Detect cycle

        for (int padosi[] : edges) {
            int u = padosi[0];
            int v = padosi[1];
            int wt = padosi[2];

            if (dis.get(u) != 100000000 && dis.get(u) + wt < dis.get(v)) {
                ArrayList<Integer> negativeCycleResponse = new ArrayList<>();
                negativeCycleResponse.add(-1);
                return negativeCycleResponse;
            }
        }

        return dis;
    }

}
