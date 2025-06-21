import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class lc140 {
    class Solution {
        HashSet<String> wordDict;
        List<String>[] memo;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = new HashSet<>(wordDict);
            memo = new List[s.length()];
            return dp(s, 0);
        }

        List<String> dp(String s, int i) {
            List<String> res = new LinkedList<>();
            if (i == s.length()) {
                res.add("");
                return res;
            }

            if (memo[i] != null) {
                return memo[i];
            }

            for (int len = 1; i + len <= s.length(); len++) {
                String pre = s.substring(i, i + len);
                if (wordDict.contains(pre)) {
                    List<String> preRes = dp(s, i + len);
                    for (String str : preRes) {
                        if (str.isEmpty()) {
                            res.add(pre);
                        } else {
                            res.add(pre + " " + str);
                        }
                    }
                }
            }

            return memo[i] = res;
        }

    }
}
