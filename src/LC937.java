import java.util.Arrays;
import java.util.Comparator;

public class LC937 {
    public String[] reorderLogFiles(String[] logs) {
       Arrays.sort(logs, new comp());
       return logs;
    }

    public class comp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String[] sp1 = s1.split(" ", 2);
            String[] sp2 = s2.split(" ", 2);
            boolean d1 = Character.isDigit(sp1[1].charAt(0)),
                    d2 = Character.isDigit(sp2[1].charAt(0));
            if (!d1 && !d2) {
                int t = sp1[1].compareTo(sp2[1]);
                if (t==0) return sp1[0].compareTo(sp2[0]);
                return t;
            }
            if (d1 && d2) {
                return 0;
            }
            if (d1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
