import java.util.Arrays;

public class LCWeek174_4 {

    int[] mj;
    int len;

    public int maxJumps(int[] arr, int d) {
        if (arr.length <= 1) {
            return 1;
        }
        len = arr.length;
        mj = new int[len];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret = Math.max(ret, max(i, arr, d));
        }
        System.out.println(Arrays.toString(mj));
        return ret;
    }

    private int max(int index, int[] arr, int d) {
        if (mj[index] > 0) {
            return mj[index];
        }
        int max = 1;
        for (int i = index-1; i >= index-d; i--) {
            if (i<0 || arr[i] >= arr[index]) break;
            max = Math.max(max(i, arr, d)+1, max);
        }
        for (int i = index+1; i <= index+d; i++) {
            if (i>=len || arr[i] >= arr[index]) break;
            max = Math.max(max(i, arr, d)+1, max);
        }
        mj[index] = max;
        return max;
    }

    public static void main(String[] args) {
        LCWeek174_4 ans = new LCWeek174_4();
        System.out.println(ans.maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 11));
        System.out.println(ans.maxJumps(new int[]{3,3,3,3,3}, 2));
        System.out.println(ans.maxJumps(new int[]{7,6,5,4,3,2,1}, 2));
        System.out.println(ans.maxJumps(new int[]{7,1,7,1,7,1}, 2));
        System.out.println(ans.maxJumps(new int[]{7}, 1));
    }
}
