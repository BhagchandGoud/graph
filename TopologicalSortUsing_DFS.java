import java.util.*;
public class TopologicalSortUsing_DFS {
    
    static void dfs(ArrayList<ArrayList<Integer>>graph ,  boolean isVisited[] , int curr , Stack<Integer>stack){
        isVisited[curr] = true;
        
        for(int i : graph.get(curr)){
            if(!isVisited[i]){
                dfs(graph , isVisited , i , stack);
            }
        }
        stack.push(curr);
        
    }
    static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
		
		
		for(int i = 0 ; i < V ;i++){
		    graph.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < edges.length ;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		   
		    graph.get(u).add(v);
		}
		
		boolean isVisited[] = new boolean[V+1];
		Stack<Integer>stack = new Stack<>();
		
		for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                dfs(graph, isVisited, i, stack);
            }
        }
		
		ArrayList<Integer>ans = new ArrayList<>();
		
		while(!stack.isEmpty()){
		    ans.add(stack.pop());
		}
		return ans;
    }

    public static void main(String[] args) {
        int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        ArrayList<Integer>ans = topoSort(4 ,edges);

        int n = ans.size();

        for(int i = 0 ; i < n ; i++){
            System.err.println(ans.get(i));
        }
    }
}