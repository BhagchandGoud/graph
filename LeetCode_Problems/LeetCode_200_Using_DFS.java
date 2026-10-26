public class LeetCode_200_Using_DFS {
    int count = 0;
    int n, m;
    int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    boolean[][] isVisited;

    boolean isSafe(int x, int y, char[][] grid) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1' && !isVisited[x][y];
    }

    void dfs(int x, int y, char[][] grid, boolean isVisited[][]) {
        isVisited[x][y] = true;

        for (int dir[] : directions) {
            int new_x = x + dir[0];
            int new_y = y + dir[1];
            if (isSafe(new_x, new_y, grid)) {

                dfs(new_x, new_y, grid, isVisited);

            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(i, j, grid, isVisited);
                    count++;
                }
            }
        }

        return count;
    }

}
