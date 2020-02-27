package MathworksOA;

import java.util.*;

class UF {
    private int[] parent;

    UF(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public int find(int i) {
        if (parent[i]<0) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi==pj) return;
        if (parent[pi]>parent[pj]) {
            parent[pj]+=parent[pi];
            parent[pi] = pj;
        } else {
            parent[pi]+=parent[pj];
            parent[pj] = pi;
        }
    }
}

public class Traveling_is_fun {
    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        UF uf = new UF(n + 1);
        for (int i = g+1; i<=n; i++) {
            for (int j = 2*i; j<=n; j+=i) {
                if (gcd(i,j)>g) {
                    uf.union(i,j);
                }
            }
        }
        int[] ret = new int[originCities.length];
        for (int i=0; i<originCities.length; i++) {
            if (uf.isConnected(originCities[i],destinationCities[i])) ret[i]=1;
        }
        return ret;
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public static void main(String[] args) {
        Traveling_is_fun ans = new Traveling_is_fun();
        System.out.println(Arrays.toString(ans.connectedCities(6, 1, new int[]{1, 2, 4, 6}, new int[]{3, 3, 3, 4})));
    }
}
