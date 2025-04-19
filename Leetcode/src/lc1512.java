import java.util.HashMap;
import java.util.Map;

public class lc1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int a = map.get(key);
            int b = a * (a - 1) / 2;
            res += b;
        }
        return res;
    }
}
