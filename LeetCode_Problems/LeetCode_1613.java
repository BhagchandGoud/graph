import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int row, col, distance;

    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class LeetCode_1613 {

    int rows, cols;

    int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    boolean isSafe(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int minimumEffortPath(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        int[][] res = new int[rows][cols];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        res[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int r = current.row;
            int c = current.col;
            int d = current.distance;

            if (r == rows - 1 && c == cols - 1) {
                return d;
            }

            if (d > res[r][c])
                continue;
            for (int dire[] : directions) {
                int x_ = r + dire[0];
                int y_ = c + dire[1];

                if (isSafe(x_, y_)) {
                    int absDiff = Math.abs(heights[r][c] - heights[x_][y_]);
                    int maxDiff = Math.max(d, absDiff);

                    if (res[x_][y_] > maxDiff) {
                        res[x_][y_] = maxDiff;
                        pq.add(new Pair(x_, y_, maxDiff));
                    }
                }
            }
        }

        return res[rows - 1][cols - 1];
    }

    
}
