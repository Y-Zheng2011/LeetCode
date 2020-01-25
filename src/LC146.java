import java.util.HashMap;
import java.util.Map;

public class LC146 {
    private class dNode {
        int key, value;
        dNode prev, next;

        dNode() {}

        dNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void add(dNode n) {
        if (map.containsKey(n.key)) {
            remove(map.get(n.key));
        }
        if (size >= capacity) {
            removeTail();
        }
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
        size++;
        map.put(n.key, n);
    }

    private dNode remove(dNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
        return map.remove(n.key);
    }

    private dNode removeTail() {
        dNode ret = tail.prev;
        remove(tail.prev);
        map.remove(ret.key);
        return ret;
    }

    Map<Integer, dNode> map = new HashMap<>();
    int size, capacity;
    dNode head, tail;

    public LC146(int capacity) {
        this.capacity = capacity;
        head = new dNode();
        tail = new dNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            dNode tmp = remove(map.get(key));
            add(tmp);
            return tmp.value;
        } else return -1;
    }

    public void put(int key, int value) {
        add(new dNode(key, value));
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LC146 ans = new LC146(2);
        ans.put(2, 1);
        ans.put(2, 2);
        System.out.println(ans.get(2));
        ans.put(1, 1);
        ans.put(4, 1);
        System.out.println(ans.get(2));
    }
}
