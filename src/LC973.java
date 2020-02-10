import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {
/*    private class point {
        int x;
        int y;

        point(int[] p) {
            x = p[0];
            y = p[1];
        }

        int dist() {
            return x*x+y*y;
        }
    }


    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<point> pq = new PriorityQueue<>(K, (o1, o2) -> o2.dist()-o1.dist());
        for (int i = 0; i < K; i++) {
            pq.offer(new point(points[i]));
        }
        for (int i = K; i < points.length; i++) {
            point p = new point(points[i]);
            if (p.dist()>pq.peek().dist()) continue;
            pq.poll();
            pq.offer(new point(points[i]));
        }
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            point p = pq.poll();
            ret[i][0]=p.x;
            ret[i][1]=p.y;
        }
        return ret;
    }*/

    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) {
                r--;
            }
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) {
                l++;
            }
            A[r]=A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    public static void main(String[] args) {
        LC973 ans = new LC973();
        System.out.println(Arrays.deepToString(ans.kClosest(new int[][]{{3, 3},{5,-1},{-2, 4}}, 2)));
    }

}
