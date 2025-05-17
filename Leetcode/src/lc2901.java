import java.util.ArrayList;
import java.util.List;

public class lc2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] f = new int[n];
        int[] from = new int[n];
        int maxI = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (f[i] < f[j] && groups[j] != groups[i] && check(words[i], words[j])) {
                    f[i] = f[j];
                    from[i] = j;
                }
            }
            f[i]++;
            if (f[i] > f[maxI]) {
                maxI = i;
            }
        }

        int i = maxI;
        int m = f[maxI];
        List<String> ans = new ArrayList<>(m);
        for (int k = 0; k < m; k++) {
            ans.add(words[i]);
            i = from[i];
        }

        return ans;
    }

    private boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (res) {
                    return false;
                }
                res = true;
            }
        }

        return res;
    }
}
