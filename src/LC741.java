import java.util.*;

public class LC741 {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] dp = new int[2*N-1][N][N];

        for (int i=0; i<2*N-1; i++) {
            for (int j=0; j<N; j++) {
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];

        for (int i=1; i<2*N-1; i++) {
            for (int x2=0; x2<=Math.min(i,N-1); x2++) {
                for (int x1=0; x1<=x2; x1++) {
                    if (i-x1>=N || i-x2>=N || grid[x1][i-x1]==-1 || grid[x2][i-x2]==-1) continue;
                    int prev = Integer.MIN_VALUE;
                    if (x1>0) prev = Math.max(dp[i-1][x1-1][x2], dp[i-1][x1-1][x2-1]);
                    prev = Math.max(dp[i-1][x1][x2], prev);
                    if (x1!=x2) {
                        prev = Math.max(dp[i-1][x1][x2-1], prev);
                        dp[i][x1][x2] = prev + grid[x1][i-x1] + grid[x2][i-x2];
                    } else {
                        dp[i][x1][x2] = prev + grid[x1][i-x1];
                    }
                }
            }
        }
        return Math.max(0,dp[2*N-2][N-1][N-1]);
    }

    public static void main(String[] args) {
        LC741 ans = new LC741();
        System.out.println(ans.cherryPickup(new int[][]{{1,1,-1,1,1},{1,1,1,1,1},{-1,1,1,-1,-1},{0,1,1,-1,0},{1,0,-1,1,0}}));
    }
}
