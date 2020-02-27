import java.util.List;

public class Policy{

    int finalInstance(int instance, List<Integer> averageUtil) {
        for (int i=0; i<averageUtil.size(); i++) {
            int curr = averageUtil.get(i);
            if (curr < 25) {
                instance = (instance+1)/2;
                i+=10;
            } else if (curr < 60) {
                continue;
            } else {
                if (instance*2>200000000) continue;
                instance *= 2;
                i+=10;
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Policy ans = new Policy();
        System.out.println(ans.finalInstance(2, List.of(25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80)));
    }
}
