import java.util.*;

public class LeetCode_841_Using_BFS {

    static  boolean canVisitAllRooms(List<List<Integer>>rooms) {
            Queue<Integer> q = new LinkedList<>();
            boolean isVisited[] = new boolean[rooms.size()];
            q.add(0);
            isVisited[0] = true;

            int count = 0;

            while (!q.isEmpty()) {
                int n = q.size();
                count++;
                int curr = q.poll();

                while (n-- > 0) {

                    for (int padosi : rooms.get(curr)) {
                        if (!isVisited[padosi]) {
                            isVisited[padosi] = true;
                            q.add(padosi);
                        }
                    }
                }

            }

        return count == rooms.size();
    }
}