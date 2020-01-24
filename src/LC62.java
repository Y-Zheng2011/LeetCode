public class LC62 {
    public int uniquePaths(int m, int n) {
        int l,s;
        if (m < 2 || n < 2) return 1;
        if (m > n) {
            l = m-1;
            s = n-1;
        } else {
            l = n-1;
            s = m-1;
        }
        long ret = l+s;
        for (int i=1; i<=s-1; i++) {
            ret = ret / i * (l+s-i);
        }
        ret = ret / s;
        return (int) ret;
    }

    public static void main(String[] args) {
        LC62 ans = new LC62();
        System.out.println(ans.uniquePaths(3,2));
        System.out.println(ans.uniquePaths(3,7));
        System.out.println(ans.uniquePaths(23, 12));
        System.out.println(ans.uniquePaths(59,5));
    }
}
