import java.util.*;

public class LC269 {
    Map<Character, Set<Character>> graph;
    Stack<Character> s = new Stack<>();
    boolean[] seen = new boolean[26];

    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        Arrays.fill(seen, false);
        for (int i = 0; i < words.length; i++) {
            boolean set = false;
            char c1, c2;
            char[] edge = null;
            for (int j = 0; j < words[i].length(); j++) {
                c2 = words[i].charAt(j);
                if (!set && i > 0 && j < words[i - 1].length() && words[i].charAt(j) != words[i - 1].charAt(j)) {
                    c1 = words[i - 1].charAt(j);
                    set = true;
                    edge = new char[]{c1, c2};
                }
                if (!graph.containsKey(c2)) {
                    graph.put(c2, new HashSet<>());
                }
            }
            if (edge != null) {
                graph.get(edge[0]).add(edge[1]);
            }
        }
        for (char ch : graph.keySet()) {
            if (!seen[ch - 'a']) {
                Set<Character> t = new HashSet<>();
                t.add(ch);
                topoSort(ch, t);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        String ret = sb.toString();
        return ret.length()==graph.size() ? ret : "";
    }

    private void topoSort(char ch, Set<Character> recur) {
        seen[ch - 'a'] = true;
        for (char tmp : graph.get(ch)) {
            if (recur.contains(tmp)) return;
            if (!seen[tmp - 'a']) {
                recur.add(tmp);
                topoSort(tmp, recur);
                recur.remove(tmp);
            }
        }
        s.push(ch);
    }

    public static void main(String[] args) {
        LC269 ans = new LC269();
        System.out.println(ans.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(ans.alienOrder(new String[]{"zt", "zaf"}));
        System.out.println(ans.alienOrder(new String[]{"a","b","c","a"}));
    }
}
