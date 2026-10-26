import java.util.*;

public class LeetCode_886_Using_BFS {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> color = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            color.add(-1);
        }

        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int start = 0; start < n; start++) {
            if (color.get(start) == -1) {
                Queue<Integer> q = new LinkedList<>();

                q.add(start);
                color.set(start, 0);

                while (!q.isEmpty()) {
                    int size = q.size();

                    int curr = q.poll();

                    for (int padosi : adj.get(curr)) {
                        if (color.get(padosi) == color.get(curr)) {
                            return false;
                        }
                        if (color.get(padosi) == -1) {
                            q.add(padosi);
                            color.set(padosi, 1 - color.get(curr));
                        }
                    }
                }
            }
        }
        return true;
    }
}