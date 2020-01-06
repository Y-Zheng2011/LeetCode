public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LC35 ans = new LC35();
        int[] nums = {1,3,5};
        System.out.println(ans.searchInsert(nums, 5));
        System.out.println(ans.searchInsert(nums, 2));
        System.out.println(ans.searchInsert(nums, 7));
        System.out.println(ans.searchInsert(nums, 0));
    }
}
