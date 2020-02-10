import java.util.ArrayList;
import java.util.List;

public class LC78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backTrack(ret, new ArrayList<Integer>(),0, nums);
        return ret;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> curr, int start, int[] nums) {
        ans.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backTrack(ans, curr, i+1, nums);
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        LC78 ans = new LC78();
        ans.subsets(new int[]{1, 2, 3});
    }
}
