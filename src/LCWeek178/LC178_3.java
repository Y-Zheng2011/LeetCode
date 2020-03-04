public class LC178_3 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

/*        ListNode of(int[] input) {
            ListNode head = new ListNode(input[0]);
            ListNode p = head;
            for (int i=1; i<input.length; i++) {
                p.next = new ListNode(input[i]);
                p = p.next;
            }
            return head;
        }*/
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        else if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode curr, TreeNode root) {
        if (curr == null) return true;
        else if (root == null) return false;
        if (curr.val!=root.val) return false;
        else return dfs(curr.next, root.left) || dfs(curr.next, root.right);
    }

}
