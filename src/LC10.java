public class LC10 {

    //Recursive solution; Time complexity is high due to substring() method.
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean char1 = !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));

        if (p.length() > 1 && p.charAt(1) == '*') {
            return (char1 && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return char1 && isMatch(s.substring(1), p.substring(1));
        }
    }

    //DP solution.
    public boolean isMatchDP(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean[][] match = new boolean[ls+1][lp+1];
        match[ls][lp] = true;

        for (int i = ls; i >= 0; i--) {
            for (int j = lp - 1; j >= 0; j--) {
                boolean char1 = i < ls && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                if (j < lp - 1 && p.charAt(j + 1) == '*') {
                    match[i][j] = (char1 && match[i + 1][j]) || match[i][j + 2];
                } else {
                    match[i][j] = char1 && match[i+1][j+1];
                }
            }
        }

        return match[0][0];
    }

    public static void main(String[] args) {
        LC10 ans = new LC10();
        /*System.out.println(ans.isMatch("aa","a"));
        System.out.println(ans.isMatch("aa","a*"));
        System.out.println(ans.isMatch("ab",".*"));
        System.out.println(ans.isMatch("aab","c*a*b"));
        System.out.println(ans.isMatch("mississippi","mis*is*p*"));
        System.out.println(ans.isMatch("",".*"));
        System.out.println(ans.isMatch("ab",".*"));*/
        System.out.println(ans.isMatchDP("aa","a"));
        System.out.println(ans.isMatchDP("aa","a*"));
        System.out.println(ans.isMatchDP("ab",".*"));
        System.out.println(ans.isMatchDP("aab","c*a*b"));
        System.out.println(ans.isMatchDP("mississippi","mis*is*p*"));
        System.out.println(ans.isMatchDP("",".*"));
        System.out.println(ans.isMatchDP("ab",".*"));
    }
}
