import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_547_WithOut_Recursion {

    static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }

            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[n];
        int count = 0;

        for (int start = 0; start < n; start++) {
            if (!isVisited[start]) {
                count++;

                q.add(start);
                isVisited[start] = true;

                while (!q.isEmpty()) {

                    int curr = q.poll();

                    for (int padosi : adj.get(curr)) {
                        if (!isVisited[padosi]) {
                            isVisited[padosi] = true;
                            q.add(padosi);
                        }
                    }
                }
            }
        }
        return count;
    }

}
