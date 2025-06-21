import java.util.Arrays;
import java.util.List;

public class lc139 {
    class Solution {
        List<String> wordDict;
        int[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dp(s, 0);
        }

        boolean dp(String s, int i) {

            if (i == s.length()) {
                return true;
            }

            if (memo[i] != -1) {
                return memo[i] == 0 ? false : true;
            }

            for (int len = 1; i + len <= s.length(); len++) {
                for (String str : wordDict) {
                    if (s.substring(i, i + len).equals(str)) {
                        boolean flag = dp(s, i + len);
                        if (flag) {
                            memo[i] = 1;
                            return true;
                        }
                    }
                }
            }

            memo[i] = 0;
            return false;
        }
    }
}
