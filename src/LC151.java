public class LC151 {
    public String reverseWords(String s) {
        s =  s.trim();
        String[] array = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i>= 0; i--) {
            if (array[i].length() > 0) {
                sb.append(array[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LC151 ans = new LC151();
        System.out.println(ans.reverseWords("  hello world!  "));
        System.out.println(ans.reverseWords("a good   example"));
    }
}
