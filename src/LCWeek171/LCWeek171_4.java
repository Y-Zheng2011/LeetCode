public class LCWeek171_4 {

    private int calc(int i, int j) {
        return Math.abs(i % 6 - j % 6) + Math.abs(i / 6 - j / 6);
    }

    public int minimumDistance(String word) {
        int[][] dist = new int[27][27];


        for (int i = 0; i < 27; i++) {
            dist[i][26]=0;
            dist[26][i]=0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = calc(i, j);
            }
        }

        int[][][] cost = new int[word.length()+1][27][27];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                cost[0][i][j] = 0;
            }
        }

        for (int s = 1; s < word.length()+1; s++) {
            int cx = word.charAt(s-1) - 'A';
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    cost[s][i][j] = Math.min(cost[s-1][cx][j] + dist[i][cx],
                            cost[s-1][i][cx] + dist[j][cx]);
                }
            }
        }

        return cost[word.length()][26][26];
    }

    public static void main(String[] args) {
        LCWeek171_4 ans = new LCWeek171_4();
        System.out.println(ans.minimumDistance("C"));
    }
}
