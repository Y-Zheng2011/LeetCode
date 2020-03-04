import java.util.Arrays;

public class LC178_1 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums==null || nums.length<1) return null;
        int[] ret = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i==j) continue;
                if (nums[i]>nums[j]) ret[i]++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC178_1 ans = new LC178_1();
        System.out.println(Arrays.toString(ans.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(ans.smallerNumbersThanCurrent(new int[]{})));
    }
}
