import java.util.Arrays;

public class lc0511Q1 {
    public int minDeletion(String s, int k) {
        int[] count = new int[26];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sum++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                if (sum <= k) {
                    break;
                }
                res += count[i];
                sum--;
            }
        }
        return res;
    }
}
