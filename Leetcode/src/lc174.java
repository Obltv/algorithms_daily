import java.util.Arrays;

public class lc174 {
    class Solution {
        int[][] memo;

        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            memo = new int[m][n];
            for (int[] me : memo) {
                Arrays.fill(me, Integer.MAX_VALUE);
            }

            return dp(0, 0, dungeon);
        }

        int dp(int i, int j, int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            if (i == m - 1 && j == n - 1) {
                return memo[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
            }
            if (i == m || j == n) {
                return Integer.MAX_VALUE;
            }

            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            int res = Math.min(dp(i + 1, j, dungeon), dp(i, j + 1, dungeon)) - dungeon[i][j];

            return memo[i][j] = res <= 0 ? 1 : res;

        }
    }
}
