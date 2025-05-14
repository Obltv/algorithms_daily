public class lc3335 {
    static int mod = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        while (t-- > 0) {
            int[] next = new int[26];
            next[0] = cnt[25];
            next[1] = (cnt[25] + cnt[0]) % mod;
            for (int i = 2; i < 26; i++) {
                next[i] = cnt[i - 1] % mod;
            }
            cnt = next;
        }

        for (int i = 0; i < 26; i++) {
            ans = (ans + cnt[i]) % mod;
        }
        return ans;
    }
}
