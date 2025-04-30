import java.util.HashMap;
import java.util.Map;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (hm.containsKey(sum[i] - k)) {
                res += hm.get(sum[i] - k);
            }
            hm.put(sum[i], hm.getOrDefault(sum[i], 0) + 1);
        }

        return res;
    }
}
