public class lc3330 {
    class Solution {
        public int possibleStringCount(String word) {
            int right = 0;
            int n = word.length();
            int res = 0;
            while (right < n) {
                char c = word.charAt(right);
                while (right < n && word.charAt(right) == c) {
                    right++;
                    res++;
                }
                res--;
            }

            return res + 1;
        }
    }
}
