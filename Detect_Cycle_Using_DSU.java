import java.util.*;

public class Detect_Cycle_Using_DSU{
    int find(int x , int parent[]){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x] , parent);
    }
    void union(int x , int y , int parent[] , int rank[]){
        
        int x_parent = find(x , parent);
        int y_parent = find(y , parent);
        
        if(x_parent == y_parent){
            return;
        }
        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
             parent[x_parent] = y_parent;
             rank[y_parent]++;
        }
        
    }
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int parent[] = new int[V];
        int rank[] = new int[V];
        
        for(int i = 0; i < V ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int u = 0 ; u < V ; u++){
            for(int v : adj.get(u)){
                if(u < v){
                    int parent_u = find(u , parent);
                    int parent_v = find(v , parent);
                    
                    if(parent_u == parent_v){
                        return true;
                    }
                    union(u , v , parent , rank);
                }
            }
        }
        return false;
    }
}