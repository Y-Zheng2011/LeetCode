import java.util.HashSet;
import java.util.Set;

public class LCWeek175_1 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr) {
            if (i==0) {
                if (s.contains(0)) return true;
            } else if (s.contains(2 * i)) {
                return true;
            }
            s.add(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]!=0 && s.contains(2 * arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LCWeek175_1 ans = new LCWeek175_1();
        System.out.println(ans.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }
}
