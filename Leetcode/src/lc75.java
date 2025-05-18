public class lc75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        sort(nums, left, right);

    }

    void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partion(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    int partion(int[] nums, int left, int right) {
        int low = left + 1;
        int high = right;
        int mid = nums[left];
        while (low <= high) {
            while (low <= high && nums[low] <= mid) {
                low++;
            }
            while (low <= high && nums[high] > mid) {
                high--;
            }
            if (low >= high) {
                break;
            }
            temp(nums, low, high);
        }
        temp(nums, left, high);
        return high;
    }

    void temp(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }
}
