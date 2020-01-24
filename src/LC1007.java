public class LC1007 {
    public int minDominoRotations(int[] A, int[] B) {
        if (A[0]==B[0]) {
            return minRot(A[0], A, B);
        } else {
            int a = minRot(A[0], A, B), b = minRot(B[0], A, B);
            if (a>0 && b>0) {
                return Math.min(a,b);
            } else {
                return Math.max(a,b);
            }
        }
    }

    private int minRot(int x, int[] A, int[] B) {
        int countA=0, L=A.length;
        for (int i=0; i < A.length; i++) {
            if (A[i]==B[i]) {
                if (A[i]==x) {
                    L--;
                } else {
                    return -1;
                }
            } else {
                if (A[i]==x) {
                    countA++;
                } else if (B[i]!=x) {
                    return -1;
                }
            }
        }
        return Math.min(countA, L-countA);
    }
    public static void main(String[] args) {
        LC1007 ans = new LC1007();
        System.out.println(ans.minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(ans.minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
        System.out.println(ans.minDominoRotations(new int[]{1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1}));
    }
}
