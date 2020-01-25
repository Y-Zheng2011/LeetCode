public class LC53 {
    public int maxSubArray(int[] nums) {
        int ret = Integer.MIN_VALUE;
        if (nums==null || nums.length<1) return ret;
        int curr = -1;
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(nums[i], nums[i] + curr);
            ret = Math.max(curr, ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC53 ans = new LC53();
        System.out.println(ans.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(ans.maxSubArray(new int[]{1}));
        System.out.println(ans.maxSubArray(new int[]{}));
    }
}
