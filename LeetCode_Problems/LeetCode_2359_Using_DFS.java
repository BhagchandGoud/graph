import java.util.*;

public class LeetCode_2359_Using_DFS {
    void dfs(int []edges, int dis[] , boolean isVisited[] , int curr){
        isVisited[curr] = true;

        int v = edges[curr];

        if(v != -1 && !isVisited[v]){
            isVisited[v] = true;
            dis[v] = 1 + dis[curr];
            dfs(edges , dis , isVisited , v);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dis_1[] = new int[n];
        int dis_2[] = new int[n];
        Arrays.fill(dis_1 , Integer.MAX_VALUE);
        Arrays.fill(dis_2 , Integer.MAX_VALUE);

        boolean isVisited_1[] = new boolean[n];
        boolean isVisited_2[] = new boolean[n];

        dis_1[node1] = 0;
        dis_2[node2] = 0;

        dfs(edges , dis_1 , isVisited_1, node1);
        dfs(edges , dis_2 , isVisited_2, node2);

        int minDistNode = -1;
        int minDistanceTillNow = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            int maxD = Math.max(dis_1[i] , dis_2[i]);
            if(minDistanceTillNow > maxD){
                minDistanceTillNow = maxD;
                minDistNode = i;
            }
        }
        return minDistNode;
    }
}