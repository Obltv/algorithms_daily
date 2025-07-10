public class lc3499 {
    class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            int n = startTime.length;
            int[] free = new int[n + 1];
            free[0] = startTime[0];
            for (int i = 1; i < n; i++) {
                free[i] = startTime[i] - endTime[i - 1];
            }

            free[n] = eventTime - endTime[n - 1];

            int res = 0;
            int s = 0;
            for (int i = 0; i <= n; i++) {
                s += free[i];
                if (i < k) {
                    continue;
                }
                res = Math.max(res, s);
                s -= free[i - k];
            }

            return res;
        }
    }
}
