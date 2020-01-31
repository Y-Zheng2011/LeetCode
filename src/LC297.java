import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ret = new LinkedList<>();
        preOrder(root, ret);
        return String.join(",", ret);
    }

    private void preOrder(TreeNode root, List<String> ret) {
        if (root==null) {
            ret.add("null");
            return;
        }
        ret.add(root.val+"");
        preOrder(root.left, ret);
        preOrder(root.right, ret);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(list);
    }

    private TreeNode dfs(List<String> d) {
        if (d.get(0).equals("null")) {
            d.remove(0);
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(d.get(0)));
        d.remove(0);
        curr.left = dfs(d);
        curr.right = dfs(d);
        return curr;
    }

    public static void main(String[] args) {
        LC297 ans = new LC297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        ans.deserialize(ans.serialize(root));
    }
}
