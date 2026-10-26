import java.util.*;

class Edge {
	int u;
	int v;
	int wt;
	
	Edge(int u, int v, int wt) {
		this.u = u;
		this.v = v;
		this.wt = wt;
	}
}
public class MinimumSpanningTree_Using_Kruskal {
    int c;

    int find(int z, int parent[]) {
        if (z == parent[z]) {
            return z;
        }
        return parent[z] = find(parent[z], parent);
    }

    void union(int parent[], int rank[], int x, int y) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[y_parent] = x_parent;
            rank[y_parent]++;
        }
    }

    int Kruskal(ArrayList<Edge> edges) {

        int sum = 0;

        int[] parent = new int[c];
        int[] rank = new int[c];

        for (int i = 0; i < c; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (Edge edge : edges) {

            int parent_u = find(edge.u, parent);
            int parent_v = find(edge.v, parent);

            if (parent_u != parent_v) {
                union(parent, rank, edge.u, edge.v);
                sum += edge.wt;
            }
        }
        return sum;
    }

    public int spanningTree(int V, int[][] edges) {
        ArrayList<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            edgeList.add(new Edge(u, v, w));
        }

        c = V; // size of parent and rank array

        Collections.sort(edgeList, (a, b) -> Integer.compare(a.wt, b.wt));

        return Kruskal(edgeList);
    }
}
