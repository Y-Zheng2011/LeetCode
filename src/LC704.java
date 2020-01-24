public class LC704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC704 ans = new LC704();
        System.out.println(ans.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(ans.search(new int[]{-1,0,3,5,9,12},2));
    }
}
