// import java.util.*;

// public class Identify_Cycle_Directed_Using_DFS {

//     static boolean checkUsingDFS(int [][]adj , int curr , boolean []isVisited , boolean []isInRecursion){
//         isVisited[curr] = true;
//         isInRecursion[curr] = true;

//         for(int arr : adj[curr]){
//             if(!isVisited[arr] && checkUsingDFS(adj, arr, isVisited, isInRecursion)){
//                 return true;
//             }else if(isInRecursion[arr]){
//                 return true;
//             }
//             else{
//                 isInRecursion[curr] = false;
//                 return false;
//             }
//         }
//     }
//     static boolean isCyclic(int V , int[][]adj){

//         boolean isVisited[] = new boolean[V];
//         boolean isInRecursion[] = new boolean[V];
//         Arrays.fill(isVisited , false);
//         Arrays.fill(isInRecursion , false);

//         for(int i = 0 ; i < V ; i++){
//             if(!isVisited[i] && checkUsingDFS(adj , i ,  isVisited , isInRecursion));
//         }
//     }
//     public static void main(String[] args) {
        
//     }
// }