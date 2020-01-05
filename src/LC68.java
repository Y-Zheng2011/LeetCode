import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new LinkedList<>();
        int[] length = new int[words.length];
        int wCount = 0, lCount = 0;
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            length[i] = words[i].length();
            if (lCount + wCount + length[i] > maxWidth) {
                LRJustify(ret, q, wCount - 1, maxWidth, lCount);
                q.add(words[i]);
                wCount = 1;
                lCount = length[i];
            } else if (i == words.length - 1) {
                q.add(words[i]);
                wCount += 1;
                lCount += length[i];
                LJustify(ret, q, wCount - 1, maxWidth, lCount);
            } else {
                q.add(words[i]);
                wCount += 1;
                lCount += length[i];
            }
        }
        if (!q.isEmpty()) {
            LJustify(ret, q, wCount - 1, maxWidth, lCount);
        }
        return ret;
    }

    //nSpace is the total number of space between every two words.
    private void LRJustify(List<String> ret, Queue<String> q, int sCount, int maxWidth, int lCount) {
        if (sCount > 0) {
            int nSpace = maxWidth - lCount;
            int quo = nSpace / sCount, rem = nSpace % sCount;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < quo; i++) {
                sb.append(" ");
            }
            String space = sb.toString();
            sb = new StringBuilder();
            sb.append(q.remove());
            while (!q.isEmpty()) {
                sb.append(space);
                if (rem > 0) {
                    sb.append(" ");
                    rem -= 1;
                }
                sb.append(q.remove());
            }
            ret.add(sb.toString());
        } else {
            LJustify(ret, q, sCount, maxWidth, lCount);
        }
    }

    //nSpace is the number of space on the right side.
    private void LJustify(List<String> ret, Queue<String> q, int sCount, int maxWidth, int lCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(q.remove());
        while (!q.isEmpty()) {
            sb.append(' ');
            sb.append(q.remove());
        }
        int nSpace = maxWidth - sCount - lCount;
        for (int i = 0; i < nSpace; i++) {
            sb.append(' ');
        }
        ret.add(sb.toString());
    }

    public static void main(String[] args) {
        String[] input1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] input2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] input3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        LC68 ans = new LC68();
        for (String i : ans.fullJustify(input1, 16)) {
            System.out.println(i);
        }
        System.out.println();
        for (String i : ans.fullJustify(input2, 16)) {
            System.out.println(i);
        }
        System.out.println();
        for (String i : ans.fullJustify(input3, 20)) {
            System.out.println(i);
        }
    }
}
