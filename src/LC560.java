public class LC560 {
    public int subarraySum(int[] nums, int k) {
        if (nums==null || nums.length<1) return 0;
        int[] sum = new int[nums.length+1];
        int ret = 0;
        sum[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                if (sum[j]-sum[i] == k) ret += 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC560 ans = new LC560();
        System.out.println(ans.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(ans.subarraySum(new int[]{1, 1, -2, 3, -1}, 2));
    }
}
