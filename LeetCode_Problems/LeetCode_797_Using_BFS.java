import java.util.*;

public class LeetCode_797_Using_BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int target = n - 1;
        Queue<List<Integer>> q = new LinkedList<>();

        List<Integer> startPath = new ArrayList<>();
        startPath.add(0);
        q.add(startPath);

        List<List<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            
            List<Integer> currentPath = q.poll();
            int currentNode = currentPath.get(currentPath.size() - 1);

            if (currentNode == target) {
                result.add(new ArrayList<>(currentPath));
                continue;
            }
            

            for (int padosi : graph[currentNode]) {
                List<Integer> nextPath = new ArrayList<>(currentPath);
                nextPath.add(padosi);
                q.add(nextPath);
            }
        }
        return result;
    }
}