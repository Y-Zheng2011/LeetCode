import java.util.*;

public class LC139 {
    Set<String> dict;
    int len;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0) return true;
        len = s.length();
        dict = new HashSet<>(wordDict);
        return wordBreak(s, 0);
    }

    public boolean wordBreak(String s, int index) {
        if (len==index) return true;
        for (String str : dict) {
            if (str.length()<=(len-index) && s.substring(index, index + str.length()).equals(str) && wordBreak(s, index + str.length())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC139 ans = new LC139();
        System.out.println(ans.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }
}
