import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC200 {
    char[][] g;
    int m, n;
    //DFS
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        g = grid;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (g[i][j]=='1') {
                    dfs(i, j);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void dfs(int x, int y) {
        if (x<0||y<0||x>=m||y>=n||g[x][y]=='0') {
            return;
        }
        g[x][y] = '0';
        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
    }

    //BFS
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        g = grid;
        Queue<pair> q = new LinkedList<>();;

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    g[i][j] = '0';
                    ret++;
                    q.add(new pair(i, j));
                    while (!q.isEmpty()) {
                        pair now = q.remove();
                        if (now.x - 1 >= 0 && grid[now.x-1][now.y] == '1') {
                            q.add(new pair(now.x - 1, now.y));
                            grid[now.x-1][now.y] = '0';
                        }
                        if (now.x + 1 < m && grid[now.x+1][now.y] == '1') {
                            q.add(new pair(now.x + 1, now.y));
                            grid[now.x+1][now.y] = '0';
                        }
                        if (now.y - 1 >= 0 && grid[now.x][now.y-1] == '1') {
                            q.add(new pair(now.x, now.y - 1));
                            grid[now.x][now.y-1] = '0';
                        }
                        if (now.y + 1 < n && grid[now.x][now.y+1] == '1') {
                            q.add(new pair(now.x, now.y + 1));
                            grid[now.x][now.y+1] = '0';
                        }
                    }
                }
            }
        }
        return ret;
    }

    private static class pair {
        int x;
        int y;

        pair(int i, int j) {
            x=i;
            y=j;
        }
    }

    //Union Find
    public int numIslandsUF(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        g = grid;
        int[] parent = new int[m*n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (g[i][j]=='1') {
                    if (i+1<m && g[i + 1][j] == '1') connect(i, j, i + 1, j, parent);
                    if (j+1<n && g[i][j + 1] == '1') connect(i, j, i, j + 1, parent);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1' && parent[i * n + j] < 0) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private int find(int x, int[] parent) {
        if (parent[x]>=0) {
            parent[x] = find(parent[x], parent);
            return parent[x];
        } else {
            return x;
        }
    }

    private void connect(int x1, int y1, int x2, int y2, int[] parent) {
        int v1 = x1 * n + y1;
        int v2 = x2 * n + y2;
        int p1 = find(v1, parent);
        int p2 = find(v2, parent);
        if (p1!=p2) {
            parent[p1] += parent[p2];
            parent[p2] = p1;
        }
    }

    public static void main(String[] args) {
        LC200 ans = new LC200();
        System.out.println(ans.numIslandsDFS(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
        System.out.println(ans.numIslandsDFS(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','1'},{'0','0','0','1','0'}}));
        System.out.println(ans.numIslandsDFS(new char[][]{}));
        System.out.println(ans.numIslandsBFS(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
        System.out.println(ans.numIslandsBFS(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','1'},{'0','0','0','1','1'}}));
        System.out.println(ans.numIslandsBFS(new char[][]{}));
        System.out.println(ans.numIslandsUF(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
        System.out.println(ans.numIslandsUF(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','1'},{'0','0','0','1','0'}}));
        System.out.println(ans.numIslandsUF(new char[][]{}));
    }
}
