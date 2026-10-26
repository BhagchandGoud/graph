public class LeetCode_947_Using_DFS {
    int n, m;

    void dfs(int[][] stones, int curr, boolean isVisited[]) {

        isVisited[curr] = true;

        for (int next = 0; next < n; next++) {

            if (!isVisited[next] &&
                    (stones[next][0] == stones[curr][0] || stones[next][1] == stones[curr][1])) {
                dfs(stones, next, isVisited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        n = stones.length;
        m = stones[0].length;

        boolean isVisited[] = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {

            if (!isVisited[i]) {
                dfs(stones, i, isVisited);
                count++;
            }

        }
        return n - count;
    }

}
