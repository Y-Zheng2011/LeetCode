import java.util.Arrays;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] ret = new int[l];
        int[] tmp = new int[l];
        ret[0] = 1;
        int right = 1;
        for (int i = 1; i < l; i++) {
            ret[i] = ret[i-1]*nums[i-1];
        }
        for (int i = l - 2; i >= 0; i--) {
            right = right * nums[i+1];
            ret[i] = ret[i] * right;
        }
        return ret;
    }

    public static void main(String[] args) {
        LC238 ans = new LC238();
        System.out.println(Arrays.toString(ans.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
