public class LC178_4 {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        dp[0][0] = 0;
        return 0;
    }

    public static void main(String[] args) {
        LC178_4 ans = new LC178_4();
        //System.out.println(ans.);
    }
}
