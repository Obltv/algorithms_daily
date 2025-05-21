public class lc3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length - 1;
        if (check(nums, queries, -1)) {
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == queries.length ? -1 : left + 1;
    }

    boolean check(int[] nums, int[][] queries, int mid) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < mid + 1; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            arr[l] += val;
            arr[r + 1] -= val;
        }
        if (arr[0] < nums[0]) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
