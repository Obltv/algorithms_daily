import java.util.HashMap;
import java.util.Map;

public class lc2346 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += map.getOrDefault(nums[i] - i, 0);
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        int len = nums.length;
        long cnt = (long) len * (len - 1) / 2;
        long res = cnt - ans;
        return res;
    }
}
