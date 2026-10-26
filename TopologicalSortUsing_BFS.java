import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// this is also called a khan's algorithm
public class TopologicalSortUsing_BFS {
    static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Compute in-degrees for each vertex
        int[] inDegree = new int[V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            // Reduce in-degree for all adjacent neighbors
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        ArrayList<Integer>ans = topoSort(4 ,edges);

        int n = ans.size();

        for(int i = 0 ; i < n ; i++){
            System.err.println(ans.get(i));
        }
    }

}
