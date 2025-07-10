public class lc3440 {
    class Solution {
        private int eventTime;
        private int[] startTime, endTime;

        public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
            this.eventTime = eventTime;
            this.startTime = startTime;
            this.endTime = endTime;
            int n = startTime.length;

            int a = 0;
            int b = -1;
            int c = -1;

            for (int i = 1; i <= n; i++) {
                int sz = get(i);
                if (sz > get(a)) {
                    c = b;
                    b = a;
                    a = i;
                } else if (b < 0 || sz > get(b)) {
                    c = b;
                    b = i;
                } else if (c < 0 || sz > get(c)) {
                    c = i;
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                int sz = endTime[i] - startTime[i];
                if (i != a && i + 1 != a && sz <= get(a) ||
                        i != b && i + 1 != b && sz <= get(b) ||
                        sz <= get(c)) {
                    res = Math.max(res, get(i) + sz + get(i + 1));
                } else {
                    res = Math.max(res, get(i) + get(i + 1));
                }
            }

            return res;

        }

        private int get(int i) {
            if (i == 0) {
                return startTime[0];
            }
            int n = startTime.length;
            if (i == n) {
                return eventTime - endTime[n - 1];
            }

            return startTime[i] - endTime[i - 1];
        }
    }
}
