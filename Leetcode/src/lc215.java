public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return find(nums, k, 0, nums.length - 1);
    }

    public int find(int[] nums, int k, int left, int right) {
        int p = sort(nums, left, right);
        if (p == k) {
            return nums[p];
        } else if (p < k) {
            return find(nums, k, p + 1, right);
        } else {
            return find(nums, k, left, p - 1);
        }
    }

    public int sort(int[] nums, int left, int right) {
        int piv = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i < right && nums[i] <= piv) {
                i++;
            }
            while (j > left && nums[j] > piv) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public void swap(int[] nums, int index2, int index3) {
        int tmp = nums[index2];
        nums[index2] = nums[index3];
        nums[index3] = tmp;
    }
}
