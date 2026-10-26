import java.util.HashMap;
import java.util.Map;

public class LeetCode_2316_Using_DSU {
    int find(int x , int []parent){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x] , parent);
    }
    void union(int parent[] , int x , int y , int rank[]){
        
        int x_parent = find(x , parent);
        int y_parent = find(y , parent);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        Map<Integer , Integer>map = new HashMap<>();

        int parent[] = new int[n];
        int rank[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        // making components
        for(int arr[] : edges){
            int u = arr[0];
            int v = arr[1];

            union(parent , u , v , rank);
        }

        for(int i = 0 ; i < n ;i++){
            int papaji = find(i , parent);
            map.put(papaji , map.getOrDefault(papaji , 0)+1);
        }

        long res= 0;

        long remaining_nodes = n;

        for(Map.Entry<Integer ,Integer>e : map.entrySet()){
            long size = e.getValue();

            res += (size) * (remaining_nodes - size);
            remaining_nodes -= size;
        }
        return res;
    }
}
