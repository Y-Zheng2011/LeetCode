import java.util.Stack;

class LC20 {
    public boolean isValid(String in) {
        Stack<Character> s = new Stack<>();
        char[] input = in.toCharArray();
        char p;
        for (char ch : input) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    s.push(ch);
                    break;
                case ')':
                    p = s.empty() ? '*' : s.pop();
                    if (p != '(') {
                        return false;
                    }
                    break;
                case ']':
                    p = s.empty() ? '*' : s.pop();
                    if (p != '[') {
                        return false;
                    }
                    break;
                case '}':
                    p = s.empty() ? '*' : s.pop();
                    if (p != '{') {
                        return false;
                    }
                    break;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        LC20 ans = new LC20();
        System.out.println(ans.isValid("()[]{}"));
        System.out.println(ans.isValid("()["));
    }
}

