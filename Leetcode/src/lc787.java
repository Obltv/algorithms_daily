import java.util.*;

public class lc787 {
    class Solution {
        Map<Integer, List<int[]>> map;
        int src, dst;
        int[][] memo;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            k++;
            this.src = src;
            this.dst = dst;
            map = new HashMap<>();
            memo = new int[n][k + 1];
            for (int[] me : memo) {
                Arrays.fill(me, -888);
            }

            for (int[] f : flights) {
                int a = f[0];
                int b = f[1];
                int c = f[2];
                map.putIfAbsent(b, new ArrayList<>());
                map.get(b).add(new int[]{a, c});
            }

            return dp(dst, k);
        }

        int dp(int s, int k) {
            if (s == src) {
                return 0;
            }
            if (k == 0) {
                return -1;
            }

            if (memo[s][k] != -888) {
                return memo[s][k];
            }

            int res = Integer.MAX_VALUE;

            if (map.containsKey(s)) {
                for (int[] ma : map.get(s)) {
                    int price = ma[1];
                    int l = ma[0];
                    int sub = dp(l, k - 1);
                    if (sub != -1) {
                        res = Math.min(res, sub + price);
                    }
                }
            }

            memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
            return memo[s][k];

        }
    }
}
