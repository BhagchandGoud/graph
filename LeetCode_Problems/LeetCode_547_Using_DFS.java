import java.util.ArrayList;

public class LeetCode_547_Using_DFS {
    static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean isVisited[]) {
        isVisited[curr] = true;

        for (int padosi : graph.get(curr)) {
            if (!isVisited[padosi]) {
                dfs(graph, padosi, isVisited);
            }
        }
    }

    static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int n = isConnected.length;
        int m = isConnected[0].length;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
                
            }
        }

        boolean isVisited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(graph, i, isVisited);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int isConnected[][] = {{1,1,0},{1,1,0},{0,0,1}};

        int x = findCircleNum(isConnected);
        System.out.println(x);
    }
}
