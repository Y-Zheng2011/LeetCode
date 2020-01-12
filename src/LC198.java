public class LC198 {
    public int rob(int[] nums) {
        int[] money = new int[nums.length+2];
        money[nums.length+1]=0;
        money[nums.length]=0;
        for (int i = nums.length-1; i>=0; i--) {
            money[i] = Math.max(money[i+1], nums[i]+money[i+2]);
        }
        return money[0];
    }
}
