import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LeetCode_1926_Using_BFS {

    int n, m;

    int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    boolean Safe(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length;
        m = maze[0].length;

        boolean isVisited[][] = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0], entrance[1]));
        isVisited[entrance[0]][entrance[1]] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair curr = q.poll();

                if (!(curr.x == entrance[0]
                        && curr.y == entrance[1])
                        && (curr.x == 0 || curr.y == m - 1 || curr.x == n - 1 || curr.y == 0)) {
                    return steps;
                }

                for (int dir[] : directions) {
                    int x = curr.x + dir[0];
                    int y = curr.y + dir[1];

                    if (Safe(x, y) && !isVisited[x][y] && maze[x][y] == '.') {
                        isVisited[x][y] = true;
                        q.add(new Pair(x, y));

                    }
                }
            }
            steps++;
        }
        return -1;
    }

}
