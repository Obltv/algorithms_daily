import java.util.Arrays;

public class lc115 {
    class Solution {
        int[][] memo;

        public int numDistinct(String s, String t) {
            memo = new int[s.length()][t.length()];
            for (int[] num : memo) {
                Arrays.fill(num, -666);
            }

            return dp(s, 0, t, 0);
        }

        int dp(String s, int i, String t, int j) {
            int res = 0;

            if (j == t.length())
                return 1;

            if (s.length() - i < t.length() - j) return 0;

            if (memo[i][j] != -666) {
                return memo[i][j];
            }

            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k) == t.charAt(j)) {
                    res += dp(s, k + 1, t, j + 1);
                }
            }

            return memo[i][j] = res;
        }
    }

    class Solution2 {
        int[][] memo;

        public int numDistinct(String s, String t) {
            memo = new int[s.length()][t.length()];
            for (int[] arr : memo) {
                Arrays.fill(arr, -666);
            }

            return dp(s, 0, t, 0);
        }

        int dp(String s, int i, String t, int j) {
            if (j == t.length())
                return 1;

            if (s.length() - i < t.length() - j) {
                return 0;
            }

            if (memo[i][j] != -666) {
                return memo[i][j];
            }

            int res = 0;

            if (s.charAt(i) == t.charAt(j)) {
                res += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
            } else {
                res += dp(s, i + 1, t, j);
            }

            return memo[i][j] = res;
        }
    }
}
