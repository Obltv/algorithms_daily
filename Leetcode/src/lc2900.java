import java.util.ArrayList;
import java.util.List;

public class lc2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1 || groups[i] != groups[i + 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
