import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode_433_Using_BFS {

    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> st = new HashSet<>();

        int m = bank.length;

        for (int i = 0; i < m; i++) {
            st.add(bank[i]);
        }

        Queue<String> q = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();

        q.add(startGene);
        isVisited.add(startGene);

        int level = 0;

        while (!q.isEmpty()) {
            int k = q.size();

            while (k-- > 0) {
                String curr = q.poll();

                if (endGene.equals(curr)) {
                    return level;
                }

                for (int i = 0; i < curr.length(); i++) {
                    for (char ch : new char[] { 'A', 'C', 'G', 'T' }) {
                        StringBuilder padosi = new StringBuilder(curr);

                        padosi.setCharAt(i, ch);

                        if (!isVisited.contains(padosi.toString()) && st.contains(padosi.toString())) {
                            isVisited.add(padosi.toString());
                            q.add(padosi.toString());
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

}
