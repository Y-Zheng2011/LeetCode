import java.util.ArrayList;
import java.util.List;

public class LC1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] seed = {12,123,1234,12345,123456,1234567,12345678,123456789};
        int[] add = {11,111,1111,11111,111111,1111111,11111111,111111111};

        int l1 = String.valueOf(low).length();
        int l2 = String.valueOf(high).length();

        List<Integer> ret = new ArrayList<>();

        for (int i = l1-2; i <= l2-2; i++) {
            for (int j = 0; j < 8-i; j++) {
                if (seed[i]>=low && seed[i]<=high) {
                    ret.add(seed[i]);
                }
                seed[i] += add[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC1291 ans = new LC1291();
        System.out.println(ans.sequentialDigits(100, 300));
        System.out.println(ans.sequentialDigits(1000, 13000));
    }
}
