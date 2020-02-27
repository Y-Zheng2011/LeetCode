import java.util.Arrays;
import java.util.List;

public class WeirdFaculty {

    public int minK(List<Integer> verdict) {
        int sum=0;
        for (int i = 0; i < verdict.size(); i++) {
            if (verdict.get(i)==0) {
                verdict.set(i, -1);
                sum += -1;
            } else {
                sum += 1;
            }
        }
        int you=0;
        if (you>sum) return 0;
        for (int i = 0; i < verdict.size(); i++) {
            you += verdict.get(i);
            if (you>sum-you) return i+1;
        }
        return verdict.size();
    }

    public static void main(String[] args) {
        WeirdFaculty ans = new WeirdFaculty();
        System.out.println(ans.minK(Arrays.asList(1,0,0,1,0)));
        System.out.println(ans.minK(Arrays.asList(1,0,0,1,1)));
        System.out.println(ans.minK(Arrays.asList(1,1,1,0,1)));
    }
}
