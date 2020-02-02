import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LCWeek174_2 {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] freq = new int[arr.length];
        int index = 0;
        for (int d : arr) {
            if (!m.containsKey(d)) {
                m.put(d, index);
                freq[index]+=1;
                index++;
            } else {
                freq[m.get(d)]+=1;
            }
        }
        int[] ret = Arrays.copyOfRange(freq, 0, index+1);
        Arrays.sort(ret);
        int target = arr.length / 2;
        int sum = 0, t = 0;
        while (sum < target && t <= index) {
            sum += ret[index-t];
            t++;
        }
        return t;
    }

    public static void main(String[] args) {
        LCWeek174_2 ans = new LCWeek174_2();
        System.out.println(ans.minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(ans.minSetSize(new int[]{1000,1000,3,7}));
        System.out.println(ans.minSetSize(new int[]{7,7,7,7,7}));
    }
}
