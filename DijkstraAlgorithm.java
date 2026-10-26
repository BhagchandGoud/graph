import java.util.*;

class Pair {
    int dis;
    int node;

    Pair(int dis, int node) {
        this.dis = dis;
        this.node = node;
    }

}

public class DijkstraAlgorithm {

    // dijkstra using priority queue
    static ArrayList<Integer> dijkstra_using_priority_queue(int V, int[][] edges, int src) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis); // min heap

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            res.add(Integer.MAX_VALUE);
        }

        res.set(src, 0);

        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int dis = temp.dis;
            int node = temp.node;

            if (dis > res.get(node))
                continue;

            for (int padosi[] : adj.get(node)) {
                int adjNode = padosi[0];
                int wt = padosi[1];

                if (dis + wt < res.get(adjNode)) {
                    res.set(adjNode, dis + wt);
                    pq.add(new Pair((dis + wt), adjNode));
                }
            }
        }
        return res;
    }

    // dijkstra using tree set for undirected graph
    static ArrayList<Integer> dijkstra_using_tree_set(int V, int[][] edges, int src) {
		
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			
			adj.get(u).add(new int[] {v, wt});
			adj.get(v).add(new int[] {u, wt});
		}
		
		TreeSet<Pair> set = new TreeSet<>((a, b) -> {
			if (a.dis != b.dis)
				return Integer.compare(a.dis, b.dis);
			return Integer.compare(a.node, b.node);
		});
		
		ArrayList<Integer>res = new ArrayList<>();
		
		for (int i = 0 ; i < V ; i++) {
			res.add(Integer.MAX_VALUE);
		}
		
		res.set(src, 0);
		
		set.add(new Pair(0, src));
		
		while (!set.isEmpty()) {
			
			Pair temp = set.pollFirst();
			int dis = temp.dis;
			int node = temp.node;
			
			if (dis > res.get(node))
				continue;
			
			for (int padosi[] : adj.get(node)) {
				int adjNode = padosi[0];
				int wt = padosi[1];
				
				if (dis + wt < res.get(adjNode)) {
				    
					int oldDis = res.get(adjNode);
					if (oldDis != Integer.MAX_VALUE) {
						set.remove(new Pair(oldDis, adjNode));
					}
					
					res.set(adjNode, dis + wt);
					
					set.add(new Pair((dis + wt), adjNode));
				}
			}
			
		}
		return res;
	}

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
        int src = 2;

        ArrayList<Integer>ans1 = dijkstra_using_priority_queue(V, edges, src);
        ArrayList<Integer>ans2 = dijkstra_using_tree_set(V, edges, src);

        for (int idx = 0; idx < ans1.size(); idx++) {
            System.out.print(ans1.get(idx) + " ");
        }
        System.out.println();
        for (int idx = 0; idx < ans2.size(); idx++) {
            System.out.print(ans2.get(idx) + " ");
        }

    }
}
