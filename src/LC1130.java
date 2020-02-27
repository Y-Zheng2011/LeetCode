import java.util.Stack;

public class LC1130 {
    public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        LC1130 ans = new LC1130();
        System.out.println(ans.mctFromLeafValues(new int[]{6, 2, 3, 5, 1, 5}));
    }
}
