import java.util.Arrays;

public class lc3085 {
    class Solution {
        public int minimumDeletions(String word, int k) {
            int n = word.length();
            int[] arr = new int[26];

            for (int i = 0; i < n; i++) {
                arr[word.charAt(i) - 'a']++;
            }

            Arrays.sort(arr);
            int[] dp = new int[26];
            for (int i = 0; i < 26; i++) {
                dp[i] = sum(i, arr, k);
            }

            int[] b = new int[26];
            b[0] = arr[0];
            for (int i = 1; i < 26; i++) {
                b[i] = b[i - 1] + arr[i];
            }

            int min = dp[0];
            for (int i = 1; i < 26; i++) {
                dp[i] += b[i - 1];
                if (min > dp[i]) {
                    min = dp[i];
                }
            }

            return min;
        }

        int sum(int i, int[] arr, int k) {
            int l = arr[i] + k;
            int res = 0;
            for (int j = i + 1; j < 26; j++) {
                if (arr[j] > l) {
                    res += arr[j] - l;
                }
            }

            return res;
        }
    }
}
