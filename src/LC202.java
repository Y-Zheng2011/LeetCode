class LC202 {
  public boolean isHappy(int n) {
      int slow = n, fast = sos(sos(n));
      while (fast!=slow && fast!=1) {
        slow = sos(slow);
        fast = sos(sos(fast));
      }
      return fast==1;
  }

  private int sos(int n) {
    int ret = 0;
    while (n!=0) {
      ret += Math.pow(n%10,2);
      n = n / 10;
    }
    return ret;
  }

  public static void main(String[] args) {
    LC202 ans = new LC202();
    System.out.println(ans.isHappy(19));
    System.out.println(ans.isHappy(4));
    System.out.println(ans.isHappy(1));
  }
}