public class LC172 {
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n>=5) {
            ret += n/=5;
        }
        return ret;
    }

    public static void main(String[] args) {
        LC172 ans = new LC172();
        System.out.println(ans.trailingZeroes(200));
    }
}
