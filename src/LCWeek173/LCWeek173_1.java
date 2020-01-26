public class LCWeek173_1 {

    public int removePalindromeSub(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        if (ispalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    public boolean ispalindrome(String s) {
        int l=0, r=s.length()-1;
        while (l<=r){
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        LCWeek173_1 ans = new LCWeek173_1();
        System.out.println(ans.removePalindromeSub("ababa"));
        System.out.println(ans.removePalindromeSub("baba"));
        System.out.println(ans.removePalindromeSub(""));
    }
}
