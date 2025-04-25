import java.util.List;

public class lc2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] sum = new int[nums.size() + 1];
        for (int i = 1; i <= nums.size(); i++) {
            sum[i] = sum[i - 1] + ((nums.get(i - 1) % modulo == k) ? 1 : 0);
        }

        long res = 0;
        int[] cnt = new int[Math.min(nums.size() + 1, modulo)];
        for (int i : sum) {
            if (i >= k) {
                res += cnt[(i - k) % modulo];
            }
            cnt[i % modulo]++;
        }
        return res;
    }
}
