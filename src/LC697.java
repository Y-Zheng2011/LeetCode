import java.util.HashMap;
import java.util.Map;

public class LC697 {
    private class count {
        int start;
        int end;
        int num;

        count(int i) {
            start = i;
            end = i+1;
            num = 1;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, count> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                count tmp = map.get(nums[i]);
                tmp.end = i+1;
                tmp.num += 1;
                int m = nums[max];
                if (tmp.num>map.get(m).num || tmp.num==map.get(m).num && tmp.end-tmp.start < map.get(m).end-map.get(m).start) {
                    max = i;
                }
            } else {
                map.put(nums[i], new count(i));
            }
        }
        return map.get(nums[max]).end-map.get(nums[max]).start;
    }

    public static void main(String[] args) {
        LC697 ans = new LC697();
        System.out.println(ans.findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
