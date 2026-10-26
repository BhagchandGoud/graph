import java.util.Arrays;

public class LeetCode_785_Using_DFS {
    static boolean solve(int[][] graph, int u, int curr_color, int color[]) {

        color[u] = curr_color;

        for (int v : graph[u]) {
            if (color[v] == color[u]) {
                return false;
            }
            if (color[v] == 0) {
               int  color_of_v = -curr_color;
               if(!solve(graph, v, color_of_v , color)){
                return false;
               }
            }
        }
        return true;
    }

    static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
      

        Arrays.fill(color , 0);
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!solve(graph, i, 1, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        int graph[][] = {{1,2,3},{0,2},{0,1,3},{0,2}};

        boolean ans = isBipartite(graph);

        System.out.println(ans);
    }
}
