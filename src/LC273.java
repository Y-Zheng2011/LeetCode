public class LC273 {
    String[] nums= {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ten = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num==0) return "Zero";
        int bi = num / 1000000000;
        int mi = num / 1000000 % 1000;
        int th = num / 1000 % 1000;
        int rest = num % 1000;
        String ret = "";
        if (bi!=0) {
            ret += nums[bi]+" Billion";
        }
        if (mi!=0) {
            ret += three(mi) + " Million";
        }
        if (th!=0) {
            ret += three(th) + " Thousand";
        }
        if (rest!=0) {
            ret += three(rest);
        }
        return ret.trim();
    }

    private String two(int num) {
        int[] digits = new int[2];
        digits[0] = num/10;
        digits[1] = num%10;
        if (digits[0]==1) {
            return ten[digits[1]];
        } else if (digits[0]==0) {
            return nums[digits[1]];
        } else {
            if (digits[1]== 0) {
                return tens[digits[0]-2];
            } else {
                return tens[digits[0]-2] + " " + nums[digits[1]];
            }
        }
    }

    private String three(int num) {
        int h = num/100;
        int t = num - h*100;
        String ret = "";
        if (h!=0) {
            ret += nums[h]+" Hundred";
            if (t!=0) {
                ret += " " + two(t);
            }
        } else {
            ret = two(t);
        }
        return ret;
    }

    public static void main(String[] args) {
        LC273 ans = new LC273();
        System.out.println(ans.numberToWords(1234567891));
    }
}
