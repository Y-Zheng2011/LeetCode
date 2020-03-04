import java.util.Stack;

public class LC155 {
    Stack<pair> stack;

    /** initialize your data structure here. */
    public LC155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size()==0) stack.add(new pair(x, x));
        else {
            pair top = stack.peek();
            stack.add(new pair(x, Math.min(x, top.val)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().key;
    }

    public int getMin() {
        return stack.peek().val;
    }

    static class pair {
        int key;
        int val;

        pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
