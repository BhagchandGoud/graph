import java.util.*;

class Pair {
	int node;
	int weight;

	Pair(int node, int wt) {
		this.node = node;
		this.weight = wt;
	}
}

public class MinimumSpanningTree_Using_Prims {

	static int spanningTree(int V, int[][] edges) {
		int n = edges.length;
		int sum = 0;

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			adj.get(u).add(new Pair(v, wt));
			adj.get(v).add(new Pair(u, wt)); // Undirected graph
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

		pq.add(new Pair(0, 0));

		boolean isVisited[] = new boolean[V];
		Arrays.fill(isVisited, false);

		while (!pq.isEmpty()) {
			Pair curr = pq.poll();

			int w = curr.weight;
			int node = curr.node;

			if (isVisited[node])
				continue;

			isVisited[node] = true;
			sum += w;

			for (Pair neighbor : adj.get(node)) {
				int padosi = neighbor.node;
				int padosi_wt = neighbor.weight;

				if (!isVisited[padosi]) {
					pq.add(new Pair(padosi, padosi_wt));
				}
			}
		}
		return sum;
	}
}
