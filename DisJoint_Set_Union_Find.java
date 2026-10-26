import java.util.*;

/**
 * DisJoint_Set_Union_Find
 * 
 *
 */
public class DisJoint_Set_Union_Find {
    // without path compression
    //  worst case time complexity : O(n) , reason : increasing height
    static int find_without_path_compression(int z, ArrayList<Integer> parent) {
        if (parent.get(z) == z) {
            return z;
        }
        return find_without_path_compression(parent.get(z), parent);
    }

    // without path compression
    //  worst case time complexity : O(n) , reason : increasing height
    static int find_with_path_compression(int z, ArrayList<Integer> parent) {
        if (parent.get(z) == z) {
            return z;
        }
        return parent.set(z,  find_with_path_compression(parent.get(z), parent));
    }

    void union(int x, int y, ArrayList<Integer> parent) {

        int x_parent = find_without_path_compression(x, parent);
        int y_parent = find_without_path_compression(y, parent);

        parent.set(x_parent, y_parent);
    }

    public static void main(String[] args) {
        int size = 5;
        DisJoint_Set_Union_Find uf = new DisJoint_Set_Union_Find();
        ArrayList<Integer> parent = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            parent.add(i);
        }
        uf.union(1, 2, parent);
        uf.union(3, 4, parent);
        boolean inSameSet = uf.find_without_path_compression(1, parent) == uf.find_without_path_compression(2, parent);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);
    }

}