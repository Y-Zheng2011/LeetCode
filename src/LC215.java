public class LC215 {
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
    }

    int quickselect(int start, int end, int k) {
        if (start==end) return nums[k];

        int pi = partition(start,end);

        if (pi>k) return quickselect(start, pi - 1, k);
        else if (pi<k) return quickselect(pi + 1, end, k);
        else return nums[k];
    }

    int partition(int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        for (int i = left; i<=end; i++) {
            if (nums[i]<pivot) {
                swap(i, left);
                left++;
            }
        }
        swap(start,left-1);
        return left-1;
    }

    void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        LC215 ans = new LC215();
        ans.nums = new int[]{7,6,5,4,3,2,1};
        System.out.println(ans.quickselect(0, 6, 5));
    }
}
