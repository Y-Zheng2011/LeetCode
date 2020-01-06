import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39 {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new LinkedList<>(), candidates.length - 1);
        return ret;
    }

    public void backtrack(int[] in, int remain, List<Integer> curr, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ret.add(new LinkedList<>(curr));
        } else {
            for (int i = start; i >= 0; i--) {
                curr.add(in[i]);
                backtrack(in, remain - in[i], curr, i);
                curr.remove(curr.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        LC39 ans = new LC39();
        int[] c = {2,3,6,7};
        int target = 7;
        for (List<Integer> l : ans.combinationSum(c, target)) {
            System.out.println(l);
        }
    }
}
