import java.util.Arrays;

public class LC177_3 {
    public int[] closestDivisors(int num) {
        int[] num1 = find(num + 1);
        int[] num2 = find(num + 2);
        if (num1[1]-num1[0] > num2[1]-num2[0]) return num2;
        else return num1;
    }

    int[] find(int num) {
        int curr = (int) Math.round(Math.sqrt(num));
        while (curr > 0 && num % curr != 0) {
            curr--;
        }
        return new int[]{curr, num / curr};
    }

    public static void main(String[] args) {
        LC177_3 ans = new LC177_3();
        System.out.println(Arrays.toString(ans.closestDivisors(8)));
        System.out.println(Arrays.toString(ans.closestDivisors(123)));
        System.out.println(Arrays.toString(ans.closestDivisors(999)));
    }
}
