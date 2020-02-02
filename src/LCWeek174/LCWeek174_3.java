import java.util.LinkedList;
import java.util.List;

public class LCWeek174_3 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    List<Integer> sums = new LinkedList<>();

    public int maxProduct(TreeNode root) {
        int sum = sum(root);
        int half = sum / 2;
        int min = Integer.MAX_VALUE;
        int split = 0;
        for (int i : sums) {
            int t = Math.abs(i - half);
            if (t < min) {
                min = t;
                split = i;
            }
        }
        long ret = split;
        ret = ret *(sum-split);
        return (int) (ret % 1000000007);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = root.val;
        ret += sum(root.left);
        ret += sum(root.right);
        sums.add(ret);
        return ret;
    }

    public static void main(String[] args) {
        LCWeek174_3 ans = new LCWeek174_3();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(ans.maxProduct(node));
    }
}