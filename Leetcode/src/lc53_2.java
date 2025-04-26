public class lc53_2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int res = dp[0];
        for (int k : dp) {
            res = Math.max(res, k);
        }
        return res;
    }
}
