public class lc3443 {
    class Solution {
        private int left;

        public int maxDistance(String s, int k) {
            int[] cnt = new int['X'];
            int ans = 0;
            for (char c : s.toCharArray()) {
                cnt[c]++;
                left = k;
                ans = Math.max(ans, f(cnt['N'], cnt['S']) + f(cnt['E'], cnt['W']));
            }

            return ans;

        }

        private int f(int a, int b) {
            int d = Math.min(Math.min(a, b), left);
            left -= d;
            return Math.abs(a - b) + d * 2;
        }
    }
}
