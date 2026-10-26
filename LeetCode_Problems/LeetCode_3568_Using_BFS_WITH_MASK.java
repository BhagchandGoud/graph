import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int r;
    int c;
    int mask;
    int energy;

    Pair(int r, int c, int mask, int energy) {
        this.r = r;
        this.c = c;
        this.mask = mask;
        this.energy = energy;
    }
}

public class LeetCode_3568_Using_BFS_WITH_MASK {

    int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    int n, m;

    boolean isSafe(int x, int y) {
        return x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1;
    }

    public int minMoves(String[] classroom, int energy) {
        n = classroom.length;
        m = classroom[0].length();

        int litterCount = 0;
        int[][] litters = new int[n][m];

        int start_r = -1, start_c = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    start_r = i;
                    start_c = j;
                }
                if (ch == 'L') {
                    litters[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        if (litterCount == 0)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        boolean isVisited[][][][] = new boolean[n][m][energy + 1][1 << litterCount];

        q.add(new Pair(start_r, start_c, 0, energy));
        isVisited[start_r][start_c][energy][0] = true;

        int moves = 0;

        int targetMask = (1 << litterCount) - 1;
        int reset = energy;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                Pair current = q.poll();
                int r = current.r;
                int c = current.c;
                int mask = current.mask;
                int current_energy = current.energy;

                if (mask == targetMask) {
                    return moves;
                }

                if (current_energy <= 0) {
                    continue;
                }

                for (int dir[] : directions) {
                    int x_ = r + dir[0];
                    int y_ = c + dir[1];

                    if (isSafe(x_, y_)) {
                        int newMask = mask;
                        int newEnergy = current_energy - 1;

                        if ((classroom[x_].charAt(y_) == 'X')) {
                            continue;
                        }
                        if (classroom[x_].charAt(y_) == 'R') {
                            newEnergy = reset;
                        }

                        if (classroom[x_].charAt(y_) == 'L') {
                            int bit = litters[x_][y_];
                            newMask |= (1 << bit);
                        }

                        if (!isVisited[x_][y_][newEnergy][newMask]) {
                            isVisited[x_][y_][newEnergy][newMask] = true;
                            q.add(new Pair(x_, y_, newMask, newEnergy));
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }

}
