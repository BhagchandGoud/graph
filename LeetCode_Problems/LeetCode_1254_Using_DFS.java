public class LeetCode_1254_Using_DFS{
    int n, m;

    boolean isSafe(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    int count = 0;
    int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    boolean dfs(int[][] grid, int i, int j, boolean isVisited[][]) {
        isVisited[i][j] = true;

        boolean isClosed = !(i == n - 1 || j == m - 1 || i == 0 || j == 0);
        for (int dir[] : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (isSafe(x, y) && grid[x][y] == 0 && !isVisited[x][y]) {
                if (!dfs(grid, x, y, isVisited)) {
                    isClosed = false;
                }
            }

        }
        return isClosed;
    }

    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean isVisited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == 0) {
                    if (dfs(grid, i, j, isVisited)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}