public class LC33 {
    public int search(int[] nums, int target) {
        int l = nums.length;
        int piv = findPivot(nums);

        int ret = search(nums, target, 0, piv);
        if (ret != -1) {
            return ret;
        } else {
            return search(nums,target, piv, l);
        }
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start==end) {
            if (nums[start]==target) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end)/2;
        if (nums[mid]>target) {
            return search(nums,target,start,mid);
        } else {
            return search(nums,target,mid,end);
        }
    }

    public int findPivot(int[] nums) {

    }
}
