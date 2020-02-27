import java.util.Arrays;

public class NewOffice {
    public int maxHeight(int[] tablePositions, int[] tableHeights) {
        int ret=0;
        int[][] input = new int[tableHeights.length][2];
        for (int i = 1; i < tablePositions.length; i++) {
            input[i][0] = tablePositions[i];
            input[i][1] = tableHeights[i];
        }
        Arrays.sort(input, (o1,o2) -> o1[0]-o2[0]);
        for (int i = 1; i < tablePositions.length; i++) {
            ret = Math.max(ret, maxHeight(
                    tableHeights[i - 1],
                    tableHeights[i],
                    tablePositions[i] - tablePositions[i - 1]));
        }
        return ret;
    }

    private int maxHeight(int lh, int rh, int dist) {
        if (dist == 1) return 0;
        int diff = Math.abs(lh-rh);
        if (diff>=dist-2) {
            return Math.min(lh, rh)+dist-1;
        } else {
            return (diff+dist)/2+Math.min(lh,rh);
        }
    }

    public static void main(String[] args) {
        NewOffice ans = new NewOffice();
        System.out.println(ans.maxHeight(new int[]{1,7,4,2}, new int[]{4,11,7,5}));
    }
}
