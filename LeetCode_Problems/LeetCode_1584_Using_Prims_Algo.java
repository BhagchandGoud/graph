import java.util.*;

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

public class LeetCode_1584_Using_Prims_Algo {
    int prims_algo(ArrayList<ArrayList<Pair>> adj , int V){
        int sum = 0;
        PriorityQueue<Pair>pq = new PriorityQueue<>((a , b) -> Integer.compare(a.wt, b.wt));

        boolean isVisited[] = new boolean[V];
        Arrays.fill(isVisited , false);

        pq.add(new Pair(0 , 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int wt = curr.wt;
            int node = curr.node;

            if(isVisited[node]) continue;

            isVisited[node] = true;
            sum += wt;

            for(Pair temp : adj.get(node)){
                int padosi = temp.node;
                int padosi_wt = temp.wt;

                if(!isVisited[padosi]){
                    pq.add(new Pair(padosi , padosi_wt));
                }
            }
        }
        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        int V = points.length;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1- x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Pair(j, d));
            }
        }


        return prims_algo(adj , V);
    }
}