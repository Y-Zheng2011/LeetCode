import java.util.Stack;

public class LC42 {

    //Two pointer method
    public int trap(int[] in) {
        int ret = 0;
        int left = 0, right = in.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (in[left] < in[right]) {
                if (in[left] > leftMax) {
                    leftMax = in[left];
                } else {
                    ret += leftMax - in[left];
                }
                left++;
            } else {
                if (in[right] > rightMax) {
                    rightMax = in[right];
                } else {
                    ret += rightMax - in[right];
                }
                right--;
            }
        }

        return ret;
    }

    //Stack method
/*    public int trap(int[] height)
    {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }*/

    public static void main(String[] args) {
        LC42 ans = new LC42();
        int[] in = {1,0,3,4,1,5,2,1,2,6};
        System.out.println(ans.trap(in));
    }
}
