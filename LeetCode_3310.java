
import java.util.*;

class Node{
    boolean isVisited;
    int val;
    
    Node(int val){
        this.isVisited = false;
        this.val = val;
    }
}

public class LeetCode_3310 {
    
    static void dfs(List<List<Node>>graph , Node current){
        current.isVisited = true;

        for(Node neighbor : graph.get(current.val)){
            if(!neighbor.isVisited){
                dfs(graph , neighbor);
            }
        }
    }
    static List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }


        List<List<Node>>graph = new ArrayList<>();
       

        for(int i = 0 ; i < n ;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < invocations.length ;i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            graph.get(u).add(nodes[v]);
        }

        dfs(graph, nodes[k]);

        boolean canRemoveAll = true;

        for(int i = 0 ; i < invocations.length ; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];

            if(!nodes[u].isVisited && nodes[v].isVisited){
                canRemoveAll = false;
                break;
            }
        }

        List<Integer>ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            
            if(!canRemoveAll || !nodes[i].isVisited){
                ans.add(nodes[i].val);
            }
        }

        return ans;
    }


    public static void main(String[]args){
        int n = 5;
        int k = 0;

        int [][] invocations = {{1,2},{0,2},{0,1},{3,4}};

        List<Integer>ans = remainingMethods(n, k, invocations);

        for(int i = 0 ; i < ans.size() ; i++){
            System.out.println(ans.get(i)+ " ");
        }
    }
}