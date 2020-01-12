public class LCWeek171_2 {
    public int minFlips(int a, int b, int c) {
        int ret=0;
        while (a > 0 || b > 0 || c > 0) {
            int ar = a % 2, br = b % 2, cr = c % 2;
            if (cr == 0) {
                ret += ar + br;
            } else if (ar == 0 && br == 0) {
                ret += 1;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        LCWeek171_2 ans = new LCWeek171_2();
        System.out.println(ans.minFlips(4, 2, 7));
        System.out.println(ans.minFlips(1, 2, 3));
        System.out.println(ans.minFlips(6, 2, 5));
    }
}
