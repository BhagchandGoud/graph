public class LeetCode_3619_Using_DFS{
    int n, m;

    int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    boolean isSafe(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    long dfs(int[][] grid, int i, int j, boolean isVisited[][], int k) {
        isVisited[i][j] = true;
        
        long sum = grid[i][j];
        for (int dir[] : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (isSafe(x, y) && !isVisited[x][y] && grid[x][y] != 0) {
                sum += dfs(grid, x, y, isVisited, k);
            }
        }
        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        int count = 0;
        boolean isVisited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] &&  grid[i][j] != 0) {
                    long sum = dfs(grid, i, j, isVisited, k);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}