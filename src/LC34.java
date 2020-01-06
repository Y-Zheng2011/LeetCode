import java.util.Arrays;

public class LC34 {
    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int[] ret = {-1, -1};

        int start = 0, end = nums.length-1, mid, p = -1;

        if (end < 0) {
            return ret;
        }

        while (start<=end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                p = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (p == -1) {
            return ret;
        }

        start = 0;
        end = p;

        while (start<end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        ret[0]=end;

        start = p;
        end = nums.length;
        while (start<end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        ret[1] = end-1;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        LC34 ans = new LC34();
        System.out.println(Arrays.toString(ans.searchRange(nums, 2)));
    }
}
