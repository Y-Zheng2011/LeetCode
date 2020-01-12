public class LCWeek171_3 {
    int[] ds;

    public int makeConnected(int n, int[][] connections) {
        ds = new int[n];
        int e = connections.length;
        if (e < n-1) return -1;
        for (int i = 0; i < n; i++) {
            ds[i] = i;
        }

        for (int i = 0; i < e; i++) {
            connect(connections[i][0],connections[i][1]);
        }

        int ret = 1;
        int root = find(0);
        for (int i = 0; i < n; i++) {
            int p = find(i);
            if (root != p) {
                connect(root, p);
                ret++;
            }
        }
        return ret-1;
    }

    public void connect(int v1, int v2) {
        int r1 = find(v1), r2 = find(v2);
        if (r1 != r2) {
            ds[r2] = r1;
        }
    }

    public int find(int v) {
        while (ds[v] != v) {
            ds[v] = ds[ds[v]];
            v = ds[v];
        }
        return v;
    }

    public static void main(String[] args) {
        LCWeek171_3 ans = new LCWeek171_3();
        System.out.println(ans.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(ans.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 1}}));
        System.out.println(ans.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
        System.out.println(ans.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {4, 3}, {3, 2}}));
    }
}
