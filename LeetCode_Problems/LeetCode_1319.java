import java.util.*;

public class LeetCode_1319{
    int find(int x , int parent[]){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x] , parent);
    }
    boolean union(int parent[] , int x , int y , int rank[]){
        
        int x_parent = find(x, parent); 
        int y_parent = find(y, parent); 

        if(x_parent == y_parent){
            return false;
        }
        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
        return true;
    }
    public int makeConnected(int n, int[][] connections) {

        int parent[] = new int[n];
        int rank[] = new int[n];

        if(connections.length < n-1)
        {
            return -1;
        }
        
        for(int i = 0 ; i < n ;i++){
            parent[i] = i;
            rank[i] = 1;
        }


        int components = n;

        for(int []arr : connections){
            if (union(parent, arr[0], arr[1], rank)) { 
                components--; 
            } 
        }
        return components - 1;
    }
}