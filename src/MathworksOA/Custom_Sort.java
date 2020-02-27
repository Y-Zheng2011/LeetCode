package MathworksOA;

public class Custom_Sort {
    public int customSort(int[] input) {
        int even = 0;
        for (int i : input) {
            if (i%2==0) even++;
        }
        int ret = 0;
        for (int i=0; i<even; i++) {
            if (input[i]%2==1) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Custom_Sort ans = new Custom_Sort();
        System.out.println(ans.customSort(new int[]{13,10,21,20}));
        System.out.println(ans.customSort(new int[]{8,5,11,4,6}));
    }
}
