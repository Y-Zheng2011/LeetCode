import java.util.*;

public class LCWeek173_3 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                graph[i][j] = 10000;
                graph[j][i] = 10000;
            }
        }
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE, ret=-1;
        for (int i = n-1; i >= 0; i--) {
            int r = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    r++;
                }
            }
            if (min > r) {
                min = r;
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LCWeek173_3 ans = new LCWeek173_3();
        System.out.println(ans.findTheCity(4,
                new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}},
                4));
        System.out.println(ans.findTheCity(5,
                new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}},
                2));
    }
}
