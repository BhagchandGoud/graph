/*
   The Floyd-Warshall algorithm is a dynamic programming algorithm used to
    find the shortest paths between all pairs of vertices in a weighted graph.

    Floyd-Warshall computes the optimal paths between every
    possible starting and ending node in a single execution\.

    this algorithm also can detect negative cycle
*/

public class Floyd_Warshall_Algorithm {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = 100000000;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

    }

}
