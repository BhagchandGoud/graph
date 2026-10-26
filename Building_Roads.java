import java.util.*;

public class Building_Roads {
    static void traverse(ArrayList<ArrayList<Integer>>adj , int curr , boolean isVisited[]){
      isVisited[curr] = true;
      for(int padosi : adj.get(curr)){
        if(!isVisited[padosi]){
          traverse(adj , padosi , isVisited);
        }
      }
    }
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int m = sc.nextInt();

      ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

      for(int i = 0 ; i <= n ; i++){
        adj.add(new ArrayList<>());
      }

      boolean isVisited[] = new boolean[n+1];


      while(m-- > 0){
        int a = sc.nextInt();
        int b = sc.nextInt();
        adj.get(a).add(b);
        adj.get(b).add(a);
      }

    ArrayList<Integer>ans = new ArrayList<>();

      for(int i = 1 ; i <= n ; i++){
        if(!isVisited[i]){
          ans.add(i);
          traverse(adj , i , isVisited);
        }
      }
    int count = ans.size() - 1;

      System.out.println(count);
      for(int i = 0 ; i < count ; i++){
        System.out.println(ans.get(i) + " " + ans.get(i + 1));
      }
    }
}