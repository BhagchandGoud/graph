public class LeetCode_990_Using_DSU {

    int[] parent;
    int[] rank;

    int find(int idx) {
        if (idx == parent[idx]) {
            return idx;
        }
        return parent[idx] = find(parent[idx]);
    }

    void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) {
            return;
        }
        if (parent[x_parent] < parent[y_parent]) {
            parent[x_parent] = y_parent;
        } else if (parent[x_parent] > parent[y_parent]) {
            parent[y_parent] = x_parent;
        } else {
            parent[y_parent] = x_parent;
            rank[y_parent]++;
        }
    }

    public boolean equationsPossible(String[] equations) {

        int n = equations.length;

        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            String s = equations[i];

            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }

        }

        for (int i = 0; i < n; i++) {
            String s = equations[i];

            if (s.charAt(1) == '!') {

                int parent_first = find(s.charAt(0) - 'a');
                int parent_second = find(s.charAt(3) - 'a');

                if (parent_first == parent_second) {
                    return false;
                }
            }

        }
        return true;
    }

}
