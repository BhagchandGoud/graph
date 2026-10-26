

public class DSU_BY_SIZE{
    static int find(int x , int []parent){
    if(x == parent[x]){
      return x;
    }
    return parent[x] = find(parent[x] , parent);
  }

  static void union(int x  , int y , int[]parent , int []size){
    int parent_x = find(x , parent);
    int parent_y = find(y , parnet);

    if(parent_x == parent_y){
      return;
    }

    if(size[parent_x] > size[parent_y]){
      parent[parent_y] = parent_x;
      size[parent_x] += size[parent_y];
    }else if(size[parent_x] < size[parent_y]){
      parent[parent_x] = parent_y;
      size[parent_y] += size[parent_x];
    }else{
      // can make parent any one
      parent[parent_x] = parent_y;
      size[parent_y] += size[parent_x];
    }
  }
}