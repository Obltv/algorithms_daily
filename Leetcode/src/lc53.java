public class lc53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int minS = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            minS = Math.min(sum[i], minS);
            res = Math.max(sum[i + 1] - minS, res);
        }

        return res;
    }
}
