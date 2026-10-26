import java.util.*;

public class Labyrinth {

    static int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    static int n, m;
    static int remaining;

    static boolean isSafe(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void dfs(char edges[][], int curr_x, int curr_y, boolean isVisited[][]) {
        if (remaining == 0) {
            return;
        }
        isVisited[curr_x][curr_y] = true;
        remaining--;
        for (int dir[] : directions) {

            if (remaining == 0) {
                return;
            }

            int new_x = curr_x + dir[0];
            int new_y = curr_y + dir[1];

            if (isSafe(new_x, new_y) && !isVisited[new_x][new_y] && edges[new_x][new_y] == '.') {
                dfs(edges, new_x, new_y, isVisited);
            }
        }
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      m = sc.nextInt();
      int k = sc.nextInt();

      char edges[][] = new char[n][m];

      boolean isVisited[][] = new boolean[n][m];
      


      int start_x = -1 ;
      int start_y = -1;
      int totalFree = 0;

      for(int i = 0 ; i < n ; i++){
        String s = sc.next();
        for(int j = 0 ; j < m ; j++){
          edges[i][j] = s.charAt(j);

          if(edges[i][j] == '.'){
            totalFree++;

            if(start_x == -1){
             start_x = i;
             start_y = j;
            }
          }
        }
      }

      remaining = totalFree - k;

      dfs(edges , start_x , start_y , isVisited);

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (edges[i][j] == '.' && !isVisited[i][j]) {
            edges[i][j] = 'X';
          }
        }
      }

      for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
          System.out.print(edges[i][j]);
        }
        System.out.println();
      }

      sc.close();
    }

}
