import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return intervals;
        }
        Arrays.sort(intervals, new intervalComparator());
        List<int[]> ret = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(intervals[i][1], curr[1]);
            } else {
                ret.add(curr);
                curr = intervals[i];
            }
        }
        ret.add(curr);
        int[][] r = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            r[i] = ret.get(i);
        }
        return r;
    }

    private static class intervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    }

    public static void main(String[] args) {
        LC56 ans = new LC56();
        System.out.println(Arrays.deepToString(ans.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(ans.merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
