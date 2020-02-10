public class LCWeek175_2 {

    public int minSteps(String s, String t) {
        int[] sets = build(s);
        int[] sett = build(t);
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            if (sets[i] > sett[i]) {
                ret += sets[i] - sett[i];
            }
        }
        return ret;
    }

    private int[] build(String s) {
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i)-'a']++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LCWeek175_2 ans = new LCWeek175_2();
        System.out.println(ans.minSteps("friend", "family"));
    }
}
