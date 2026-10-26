import java.util.*;
import java.io.*;

public class CSES_COUNTING_ROOMS {
  static int count = 0;
  static int n, m;
  static int [][]directions = {{-1 , 0} , {0 , -1} , {1 , 0} , {0 , 1}};
  static char [][]grid;
  static boolean[][] isVisited;

  static boolean isSafe(int x , int y){
    return x >= 0 && x < n && y >= 0 && y < m  && grid[x][y] == '.' && !isVisited[x][y];
  }

  static void dfs(int x , int y ,  boolean isVisited[][]){
    isVisited[x][y] = true;

    for(int dir[] : directions){
      int new_x = x + dir[0];
      int new_y = y + dir[1];
      if(isSafe(new_x , new_y)){
         
           dfs(new_x , new_y , isVisited);
         
      }
    }
  }
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      grid = new char[n][m];
      isVisited = new boolean[n][m];

      for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

      for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
          if(grid[i][j] == '.' && !isVisited[i][j]){
            dfs(i , j , isVisited);
            count++;
          }
        }
      }
      System.out.print(count);
    }
}