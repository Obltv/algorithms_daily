public class lc3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = nums[i] - nums[i - 1];
        }

        int a = queries[0][0];
        int b = queries[0][1];
        arr[a]--;
        if (b + 1 < nums.length) {
            arr[b + 1]++;
        }
        for (int i = 1; i < queries.length; i++) {
            int m = queries[i][0];
            int n = queries[i][1];
            arr[m]--;
            if(n+1 < nums.length){
                arr[n + 1]++;
            }
        }
        nums[0] = arr[0];
        if (nums[0] > 0) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + arr[i];
            if (nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
