public class LCWeek171_1 {

    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i <= n / 2; i++) {
            if (noZero(i) && noZero(n - i)) {
                return new int[]{i,n-i};
            }
        }

        return null;
    }

    private boolean noZero(int n) {
        while (n>0) {
            if (n % 10 == 0) {
                return false;
            } else {
                n = n / 10;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LCWeek171_1 ans = new LCWeek171_1();
        System.out.println(ans.getNoZeroIntegers(2)[0] + " " + ans.getNoZeroIntegers(2)[1]);
        System.out.println(ans.getNoZeroIntegers(10000)[0] + " " + ans.getNoZeroIntegers(10000)[1]);
        System.out.println(ans.getNoZeroIntegers(69)[0] + " " + ans.getNoZeroIntegers(69)[1]);
        System.out.println(ans.getNoZeroIntegers(1010)[0] + " " + ans.getNoZeroIntegers(1010)[1]);
    }
}
