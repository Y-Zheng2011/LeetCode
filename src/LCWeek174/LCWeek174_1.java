import java.util.Arrays;

public class LCWeek174_1 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] ret = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int j = 0;
            while (j<mat[0].length && mat[i][j]==1) j++;
            ret[i][0] = i;
            ret[i][1] = j;
        }
        Arrays.sort(ret, (item1, item2) -> item1[1] - item2[1]);
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = ret[i][0];
        }
        return results;
    }

    public static void main(String[] args) {
        LCWeek174_1 ans = new LCWeek174_1();
        System.out.println(Arrays.toString(ans.kWeakestRows(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2)));
    }
}
