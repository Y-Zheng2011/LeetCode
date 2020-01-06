import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40 {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i < start && in[i] == in[i + 1]) continue;
                curr.add(in[i]);
                backtrack(in, remain - in[i], curr, i - 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LC40 ans = new LC40();
        int[] c = {10,1,2,7,6,1,5};
        int target = 8;
        for (List<Integer> l : ans.combinationSum2(c, target)) {
            System.out.println(l);
        }
    }
}
