import java.util.Arrays;

public class lc64 {
    class Solution {
        int[][] memo;

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            memo = new int[m][n];
            for (int[] me : memo) {
                Arrays.fill(me, -1);
            }
            memo[m - 1][n - 1] = grid[m - 1][n - 1];
            return dp(0, 0, grid);
        }

        int dp(int i, int j, int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            if (i == m - 1) {
                return memo[i][j] = dp(i, j + 1, grid) + grid[i][j];
            }

            if (j == n - 1) {
                return memo[i][j] = dp(i + 1, j, grid) + grid[i][j];
            }

            return memo[i][j] = Math.min(dp(i, j + 1, grid), dp(i + 1, j, grid)) + grid[i][j];

        }
    }
}
