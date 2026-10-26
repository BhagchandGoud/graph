import java.util.*;

public class Map_In_DFS {
    char dfs(char ch , Map<Character , Set<Character>>map ,Set<Character> visited ){
        visited.add(ch);

        char smallest = ch;
        if(!map.containsKey(ch)){
            return ch;
        }

        for(char next : map.get(ch)){
            if(!visited.contains(next)){
                char x = dfs(next , map , visited);
                if(smallest > x){
                    smallest = x;
                }
            }
        }
        return smallest;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        Map<Character , Set<Character>>map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        StringBuilder ans = new StringBuilder();

        for(char ch : baseStr.toCharArray()){
            Set<Character> visited = new HashSet<>();
            char smallest = dfs(ch, map, visited);
            ans.append(smallest);
        }
        return ans.toString();
    }
}