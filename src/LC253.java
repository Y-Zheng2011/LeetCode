import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253 {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length < 1) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, (o1, o2) -> o1-o2);

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        LC253 ans = new LC253();
        System.out.println(ans.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
}
