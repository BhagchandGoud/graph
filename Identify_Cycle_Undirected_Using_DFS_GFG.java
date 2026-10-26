import java.util.ArrayList;
import java.util.List;

public class Identify_Cycle_Undirected_Using_DFS_GFG {

    static boolean dfs(List<List<Integer>> graph, int curr, boolean isVisited[], int parent) {
        isVisited[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (!isVisited[neighbor]) {
                if (dfs(graph, neighbor, isVisited, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean isVisited[] = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                // Initial parent is set to -1
                if (dfs(graph, i, isVisited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 4;
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        boolean ans = isCycle(V, edges);
        System.out.println(ans);
    }
}
