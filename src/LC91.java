public class LC91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len==0 || s.charAt(0)=='0') return 0;

        int p, ret;
        p = 1;
        if (s.charAt(len-1)=='0') {
            ret = 0;
        } else {
            ret = 1;
        }
        for (int i = len-2; i>=0; i--) {
            char ch = s.charAt(i);
            if (ch=='0') {
                p=ret;
                ret = 0;
            } else if (ch>='3' || (ch=='2'&& s.charAt(i+1)>'6')) {
                p=ret;
            } else {
                int tmp = ret;
                ret = ret + p;
                p = tmp;
            }
        }

        //int[] dp = new int[len+1];
        //dp[len] = 1;
        // if (s.charAt(len-1)=='0') {
        //     dp[len-1]=0;
        // } else {
        //     dp[len-1]=1;
        // }
        // for (int i = len-2; i>=0; i--) {
        //     char ch = s.charAt(i);
        //     if (ch=='0') {
        //         dp[i] = 0;
        //     } else if (ch>='3' || (ch=='2'&& s.charAt(i+1)>'6')) {
        //         dp[i] = dp[i+1];
        //     } else {
        //         dp[i] = dp[i+1] + dp[i+2];
        //     }
        // }
        return ret;
    }

    public static void main(String[] args) {
        LC91 ans = new LC91();
        System.out.println(ans.numDecodings("12"));
        System.out.println(ans.numDecodings("10"));
        System.out.println(ans.numDecodings("012"));
        System.out.println(ans.numDecodings("226"));
    }
}
