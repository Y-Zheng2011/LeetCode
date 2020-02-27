package MathworksOA;

public class SpecialSubstring {
    static int countSpecial(String s) {
        char[] str = s.toCharArray();
        int len = str.length, ret = 0, vows = 0;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            if (isVow(str[i])) {
                vows++;
                count[i]=1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (count[i]==1) {
                ret += len - i - vows;
                vows--;
            } else {
                ret += vows;
            }
        }
        return ret;
    }

    static boolean isVow(char c) {
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }

    public static void main(String[] args) {
        System.out.println(countSpecial("aba"));
    }
}
