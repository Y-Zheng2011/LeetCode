import java.util.Stack;

public class LC206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//Stack
/*    public ListNode reverseList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        while (!s.isEmpty()) {
            dummy.next = s.pop();
            dummy = dummy.next;
        }
        dummy.next = null;
        return ret.next;
    }*/

//Iteration
/*    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }*/

//Recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private ListNode of(int[] data) {
        if (data.length < 1) return null;
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < data.length; i++) {
            p.next = new ListNode(data[i]);
            p = p.next;
        }
        return head.next;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LC206 ans = new LC206();
        ans.print(ans.reverseList(ans.of(new int[]{1, 2, 3, 4, 5})));
    }
}
