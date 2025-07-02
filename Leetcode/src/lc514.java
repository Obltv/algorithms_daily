import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc514 {
    class Solution {
        Map<Character, List<Integer>> map = new HashMap<>();
        int[][] memo;

        public int findRotateSteps(String ring, String key) {
            int m = ring.length();
            int n = key.length();

            memo = new int[m][n];
            for (int i = 0; i < m; i++) {
                char c = ring.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }

            return dp(ring, 0, key, 0);
        }

        int dp(String ring, int i, String key, int j) {
            if (j == key.length())
                return 0;
            if (memo[i][j] != 0) {
                return memo[i][j];
            }

            char c = key.charAt(j);
            int res = Integer.MAX_VALUE;

            for (int k : map.get(c)) {
                int m = Math.abs(k - i);
                m = Math.min(m, ring.length() - m);
                int sub = dp(ring, k, key, j + 1);
                res = Math.min(res, 1 + m + sub);
            }

            return memo[i][j] = res;
        }
    }
}
