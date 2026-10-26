import java.util.*;


public class LeetCode_1743_Using_MAP_DFS {
    int arr[];
    int i;

    void dfs(Map<Integer, Set<Integer>> map, int curr, int prev) {

        arr[i++] = curr;

        for (int padosi : map.get(curr)) {
            if (prev != padosi) {
                dfs(map, padosi, curr);
            }
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; i++) {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];

            map.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            map.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        int n = adjacentPairs.length + 1;
        arr = new int[n];
        i = 0;

        int startPoint = -1;

        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            Set<Integer> st = e.getValue();

            if (st.size() == 1) {
                startPoint = e.getKey();
                break;
            }
        }
        dfs(map, startPoint, Integer.MIN_VALUE);

        return arr;
    }
}