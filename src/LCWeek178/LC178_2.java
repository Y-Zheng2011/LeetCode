import java.util.*;

public class LC178_2 {

    public String rankTeams(String[] votes) {
        Map<Character, int[]> count = new HashMap<>();
        int len = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < len; i++) {
                char ch = vote.charAt(i);
                int[] tmp = count.getOrDefault(ch, new int[len]);
                tmp[i] += 1;
                count.putIfAbsent(ch, tmp);
            }
        }
        List<Character> ret = new ArrayList<>(count.keySet());
        Collections.sort(ret, (c1, c2) -> {
            int i = 0;
            while (i<len && count.get(c1)[i]==count.get(c2)[i]) i++;
            if (i==len) return c1-c2;
            else return count.get(c2)[i]-count.get(c1)[i];
        });
        StringBuilder sb = new StringBuilder();
        for (char ch : ret) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC178_2 ans = new LC178_2();
        System.out.println(ans.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));
    }
}
