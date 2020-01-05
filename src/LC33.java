public class LC33 {
    public int search(int[] nums, int target) {
        int l = nums.length, mid = l/2;
        if (l<1) return -1;

        int piv = findPivot(nums, 0, l-1);
        if (piv == -1) {
            return search(nums, target, 0, l);
        } else {
            int ret = search(nums, target, 0, piv);
            if (ret != -1) {
                return ret;
            } else {
                return search(nums, target, piv, l);
            }
        }

    }

    public int search(int[] nums, int target, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                return search(nums, target, start, mid);
            } else if (nums[mid] < target) {
                return search(nums, target, mid + 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums, int start, int end) {
        if (nums[start] < nums[end] || start == end) {
            return -1;
        }
        if (nums[start] > nums[start + 1]) {
            return start + 1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[end]) {
            return findPivot(nums, start, mid);
        } else {
            return findPivot(nums, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        LC33 ans = new LC33();
        System.out.println(ans.search(nums, 2) == 6);
        System.out.println(ans.search(nums, 3) == -1);
        nums = new int[]{1, 2, 4, 5, 6, 7, 0};
        System.out.println(ans.search(nums, 0) == 6);
        System.out.println(ans.search(nums, 7) == 5);
        nums = new int[]{7, 0, 1, 2, 4, 5, 6};
        System.out.println(ans.search(nums, 7) == 0);
        System.out.println(ans.search(nums, 0) == 1);
        nums = new int[]{1};
        System.out.println(ans.search(nums, 7) == -1);
        nums = new int[]{};
        System.out.println(ans.search(nums, 7) == -1);
    }
}
