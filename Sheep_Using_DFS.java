import java.util.*;
// problem available on spoj platform
public class Sheep_using_DFS {

  static int directions[][] = {{-1 , 0} , {0 , -1} , {1 , 0} , {0 , 1}};
  static int n , m;
  static int sectorSheep = 0;
  static int sectorWolves = 0;

  static boolean isSafe(int x , int y){
    return x >= 0 && x <= n-1 && y >= 0 && y <= m - 1;
  }

  static void dfs(char[][]edges , int curr_x , int curr_y , boolean isVisited[][]){
    isVisited[curr_x][curr_y] = true;

    if(edges[curr_x][curr_y] == 'k'){
      sectorSheep++;
    }else if(edges[curr_x][curr_y] == 'v'){
      sectorWolves++;
    }

    for(int dir[] : directions){
        int new_x = curr_x + dir[0];
        int new_y = curr_y + dir[1];

      if(isSafe(new_x , new_y)){
        if(!isVisited[new_x][new_y] && edges[new_x][new_y] != '#'){
          dfs(edges , new_x , new_y , isVisited);
        }
      }
    }
  }
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext() && !sc.hasNextInt()) {
      sc.next();
    }
    if (!sc.hasNextInt()) return;

    n = sc.nextInt();
    m = sc.nextInt();

    char edges[][] = new char[n][m];
     int totalSheep = 0;
     int totalWolves = 0;

    for(int i = 0; i < n; i++){
      String row = sc.next();
      for(int j = 0; j < m; j++){
        edges[i][j] = row.charAt(j);

        if(edges[i][j] == 'k'){
          totalSheep++;
        } else if(edges[i][j] == 'v'){
          totalWolves++;
        }
      }
    }

    

    boolean isVisited[][] = new boolean[n][m];


    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        
        if(!isVisited[i][j] && edges[i][j] != '#'){
          sectorSheep = 0;
          sectorWolves = 0;
          dfs(edges , i , j , isVisited);

          if(sectorSheep > sectorWolves){
            totalWolves -= sectorWolves; 
          }else{
            totalSheep -= sectorSheep;
          }
        }
      }
    }

    System.out.println(totalSheep + " " + totalWolves);
  }
}
