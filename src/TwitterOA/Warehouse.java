import java.util.List;

public class Warehouse {

    int restock(List<Integer> itemCount, int target) {
        int sum = 0;
        for (int i : itemCount) {
            sum += i;
            if (sum >= target) break;
        }
        return Math.abs(target - sum);
    }

    public static void main(String[] args) {
        Warehouse ans = new Warehouse();
        System.out.println(ans.restock(List.of(10,20,30,40,15),80));
        System.out.println(ans.restock(List.of(10,20,30,40,15),130));
        System.out.println(ans.restock(List.of(10,20,30,40,15),60));
    }

}
