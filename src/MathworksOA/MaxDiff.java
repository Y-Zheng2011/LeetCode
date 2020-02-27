package MathworksOA;

public class MaxDiff {
    static int maxDiff(int[] arr) {
        int ret = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<min) {
                min = arr[i];
            } else {
                ret = Math.max(arr[i]-min,ret);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
        System.out.println(maxDiff(new int[]{7, 9, 5, 6, 3, 2}));
    }
}
