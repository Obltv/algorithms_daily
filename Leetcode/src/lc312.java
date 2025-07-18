public class lc312 {
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] points = new int[n + 2];
            points[0] = points[n + 1] = 1;
            for (int i = 1; i <= n; i++) {
                points[i] = nums[i - 1];
            }

            int[][] memo = new int[n + 2][n + 2];

            for (int i = n; i >= 0; i--) {
                for (int j = i + 1; j < n + 2; j++) {
                    for (int k = i + 1; k < j; k++) {
                        memo[i][j] = Math.max(memo[i][j], memo[i][k] + memo[k][j] + points[i] * points[k] * points[j]);
                    }
                }
            }

            return memo[0][n + 1];
        }
    }
}
