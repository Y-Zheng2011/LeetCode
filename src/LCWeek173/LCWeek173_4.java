import java.util.Arrays;

public class LCWeek173_4 {

    int[][] memo;
    int inf = 400000;
    int len;

    private int dp(int[] job, int index, int days) {
        if (days == 0 && index == len) {
            return 0;
        }
        if (days == 0 || index == len) {
            return inf;
        }
        if (len - index < days) {
            return inf;
        }
        if (memo[index][days] != inf) {
            return memo[index][days];
        }
        int currMax = job[index], min = inf;
        for (int i = index; i < len; i++) {
            currMax = Math.max(job[i], currMax);
            int tmp = dp(job, i + 1, days - 1);
            min = Math.min(min, tmp + currMax);
        }
        memo[index][days] = min;
        return memo[index][days];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        len = jobDifficulty.length;
        memo = new int[len][d+1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], inf);
        }
        int ret = dp(jobDifficulty, 0, d);
        return ret == inf ? -1 : ret;
    }

    public static void main(String[] args) {
        LCWeek173_4 ans = new LCWeek173_4();
        System.out.println(ans.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(ans.minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(ans.minDifficulty(new int[]{1, 1, 1}, 3));
        System.out.println(ans.minDifficulty(new int[]{7,1,7,1,7,1}, 3));
        System.out.println(ans.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
    }
}
