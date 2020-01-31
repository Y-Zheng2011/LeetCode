import java.util.ArrayList;
import java.util.List;

public class LC54 {
    int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return new ArrayList<>();
        }
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ret = new ArrayList<>(m * n);
        for (int i = 0; i < Math.min(Math.ceil(m / 2.0), Math.ceil(n / 2.0)); i++) {
            ret.addAll(so(i, m-2*i, n-2*i));
        }
        return ret;
    }

    private List<Integer> so(int index, int r, int c) {
        List<Integer> ret = new ArrayList<>(2*r+2*c-4);
        for (int i = 0; i < c; i++) {
            ret.add(matrix[index][i+index]);
        }
        for (int i = 1; i < r; i++) {
            ret.add(matrix[i+index][index+c-1]);
        }
        if (r != 1 && c != 1) {
            for (int i = c-2; i >= 0; i--) {
                ret.add(matrix[index+r-1][i+index]);
            }
            for (int i = r-2; i >= 1; i--) {
                ret.add(matrix[i+index][index]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC54 ans = new LC54();
        System.out.println(ans.spiralOrder(new int[][]{{1, 2, 3}}));
        System.out.println(ans.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
