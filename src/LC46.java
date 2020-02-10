import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    boolean[] used;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        used = new boolean[len];
        List<List<Integer>> ret = new ArrayList<>();
        backTrack(ret, new ArrayList<Integer>(), 0, nums);
        return ret;
    }

    private void backTrack(List<List<Integer>> ret, List<Integer> curr, int size, int[] nums) {
        if (size==len) ret.add(new LinkedList<>(curr));
        for (int i=0; i<len; i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backTrack(ret, curr, size + 1, nums);
            curr.remove(size);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LC46 ans = new LC46();
        List<List<Integer>> t = ans.permute(new int[]{1,2,3,4});
        for (List<Integer> li : t) {
            for (int i : li) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
