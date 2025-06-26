public class lc2311 {
    class Solution {
        public int longestSubsequence(String s, int k) {
            int n = s.length();
            int m = 32 - Integer.numberOfLeadingZeros(k);
            if (n < m)
                return n;

            int sufVal = Integer.valueOf(s.substring(n - m), 2);
            int ans = sufVal <= k ? m : m - 1;

            int count = 0;
            for (int i = 0; i < n - m; i++) {
                if (s.charAt(i) == '0')
                    count++;
            }

            return ans + count;
        }
    }
}
