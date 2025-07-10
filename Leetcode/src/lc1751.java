import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1751 {
//    class Solution {
//        int[] memo;
//        List<int[]>[] list;
//        int max = 0;
//
//        public int maxValue(int[][] events, int k) {
//            int n = events.length;
//
//            for (int i = 0; i < n; i++) {
//                max = Math.max(max, events[i][1]);
//            }
//            memo = new int[max + 1];
//            Arrays.fill(memo, -1);
//            list = new List[max + 1];
//            for (int i = 0; i <= max; i++) {
//                list[i] = new ArrayList<>();
//            }
//
//            for (int i = 0; i < n; i++) {
//                int a = events[i][0];
//                int b = events[i][1];
//                int c = events[i][2];
//                list[a].add(new int[]{b, c});
//            }
//
//            int res = 0;
//            for (int i = 0; i < max; i++) {
//                if (list[i].size() == 0) {
//                    continue;
//                } else {
//                    res = Math.max(res, dp(i, events, 0, k));
//                    Arrays.fill(memo, -1);
//                }
//            }
//
//            return res;
//        }
//
//        int dp(int i, int[][] events, int m, int k) {
//            if (m == k) {
//                return 0;
//            }
//
//            if (i > max) {
//                return memo[i] = 0;
//            }
//            if (memo[i] != -1) {
//                return memo[i];
//            }
//
//            for (int[] u : list[i]) {
//                memo[i] = Math.max(memo[i], dp(u[1], events, m + 1, k) + u[2]);
//            }
//
//            return memo[i];
//        }
//    }

    class Solution {
        public int maxValue(int[][] events, int k) {
            Arrays.sort(events, (a, b) -> a[1] - b[1]);
            int n = events.length;
            int[][] dp = new int[n + 1][k + 1];

            for (int i = 0; i < n; i++) {
                int p = erfen(events, i, events[i][0]);
                for (int j = 1; j <= k; j++) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[p + 1][j - 1] + events[i][2]);
                }
            }

            return dp[n][k];
        }

        int erfen(int[][] events, int right, int max) {
            int left = 0;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (events[mid][1] < max) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return right;
        }
    }




    class Solution2 {
        int[][] memo;

        public int maxValue(int[][] events, int k) {
            //按start排序
            Arrays.sort(events, (a, b) -> a[0] - b[0]);
            int n = events.length;

            //memo[i][k] 表示从第 i 个会议开始，还能选 k 个会议的最大价值
            memo = new int[n + 1][k + 1];

            //赋特殊值
            for (int[] me : memo) {
                Arrays.fill(me, -666);
            }

            return dp(events, 0, k);
        }

        int dp(int[][] events, int i, int k) {
            //base case
            //k==0没有选择,i == events.length说明没有比当前更大的start了
            if (k == 0 || i == events.length) {
                return 0;
            }

            if (memo[i][k] != -666) {
                return memo[i][k];
            }

            //不选当前会议
            int res = dp(events, i + 1, k);

            //比当前end大的第一个start的下标
            int p = erfen(events, i);

            //选状态最大值
            res = Math.max(res, dp(events, p, k - 1) + events[i][2]);
            return memo[i][k] = res;
        }

        //二分找start
        int erfen(int[][] events, int i) {
            int end = events[i][1];

            int left = i;
            int right = events.length - 1;

            while (left <= right) {
                int mid = (left + right) >> 1;

                if (events[mid][0] > end) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

    }
}
