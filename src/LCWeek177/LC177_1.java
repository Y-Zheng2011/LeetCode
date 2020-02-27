public class LC177_1 {

    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        int[] num1 = new int[3], num2 = new int[3];
        for (int i = 0; i < 3; i++) {
            num1[i] = Integer.parseInt(d1[i]);
            num2[i] = Integer.parseInt(d2[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (num1[i] > num2[i]) {
                int[] tmp = num1;
                num1 = num2;
                num2 = tmp;
                break;
            } else if (num1[i]<num2[i]) break;
        }
        int ret = past(num2[1], num2[2]) - past(num1[1], num1[2]);
        for (int i = num1[0]; i < num2[0]; i++) {
            if (isLeap(i)) {
                ret += 1;
            }
        }
        ret += 365*(num2[0]-num1[0]);
        if (isLeap(num2[0]) && past(num2[1],num2[2])>=60) {
            ret+=1;
        }
        if (isLeap(num1[0]) && past(num1[1],num1[2])>=60) {
            ret-=1;
        }
        return ret;
    }

    private int past(int mon, int day) {
        int ret = 0;
        for (int i = 1; i<mon; i++) {
            ret += days[i];
        }
        return ret+day;
    }

    private boolean isLeap(int year) {
        if (year%400==0 || (year%100!=0 && year%4==0)) return true;
        return false;
    }

    public static void main(String[] args) {
        LC177_1 ans = new LC177_1();
        System.out.println(ans.daysBetweenDates("2009-08-18","2080-8-08"));
        System.out.println(ans.daysBetweenDates("1971-06-29","2010-09-23"));
    }
}
