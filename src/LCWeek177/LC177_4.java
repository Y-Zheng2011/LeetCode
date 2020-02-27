import java.util.Arrays;

public class LC177_4 {
    public String largestMultipleOfThree(int[] digits) {
        int[] d = new int[10];
        int ones, twos, zeros;
        for (int i : digits) {
            d[i]++;
        }
        zeros = d[0]+d[3]+d[6]+d[9];
        ones = d[1]+d[4]+d[7];
        twos = d[2]+d[5]+d[8];
        int remain = (ones+2*twos)%3;
        if (remain==1 && ones>0) {
            for (int i = 1; i <= 7; i += 3) {
                if (d[i]>0) {
                    d[i]--;
                    remain--;
                    ones--;
                    break;
                }
            }
        } else if (remain==2 && twos>0) {
            for (int i = 2; i <= 8; i += 3) {
                if (d[i]>0) {
                    d[i]--;
                    remain-=2;
                    twos--;
                    break;
                }
            }
        }
        if (remain==1 && twos>1) {
            for (int i = 2; i <= 8; i += 3) {
                while (d[i]>0 && remain>0) {
                    d[i]-=1;
                    remain = (remain+1)%3;
                    twos--;
                }
            }
        } else if (remain==2 && ones>1) {
            for (int i = 1; i <= 7; i += 3) {
                while (d[i]>0 && remain>0) {
                    d[i]-=1;
                    remain-=1;
                    ones--;
                }
            }
        }
        if (remain>0) return "";
        StringBuilder ret = new StringBuilder();
        int i=9;
        while (i>0) {
            for (int j = 0; j < d[i]; j++) {
                ret.append(i);
            }
            i--;
        }
        if (ret.length()==0){
            if (d[0]>0) return "0";
            else return "";
        }
        for (int j = 0; j < d[0]; j++) {
            ret.append(i);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LC177_4 ans = new LC177_4();
        System.out.println(ans.largestMultipleOfThree(new int[]{8,9,8}));
    }
}
