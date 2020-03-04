public class LC25 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode kPos = head;
        int i=0;
        while (i<k && kPos!=null) {
            kPos = kPos.next;
            i++;
        }
        if (i!=k) return head;
        kPos = reverse(dummy, kPos);
        kPos.next = reverseKGroup(kPos.next, k);
        return dummy.next;
    }

    private static ListNode reverse(ListNode head, ListNode tail){
        ListNode p = head;
        ListNode c = p.next;
        ListNode n = c;
        while (c!=tail) {
            n = n.next;
            c.next = p;
            p = c;
            c = n;
        }
        c = head.next;
        c.next = tail;
        head.next = p;
        return c;
    }

    private ListNode makeList(int n) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i=2; i<=n; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return head;
    }

    private void print(ListNode head) {
        while (head.next!=null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        LC25 ans = new LC25();
        ans.print(ans.reverseKGroup(ans.makeList(5),2));
    }

}
