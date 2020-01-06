public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                contains1 = true;
            }
        }

        if (!contains1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums[i]);
            if (t == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[t] = -Math.abs(nums[t]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0)
            return n;
        return n + 1;
    }

    public static void main(String[] args) {
        LC41 ans = new LC41();
        int[] n = {3,2,0};
        System.out.println(ans.firstMissingPositive(n));
    }
}
