import java.util.HashMap;

public class lc594 {
    class Solution {
        public int findLHS(int[] nums) {
            int n = nums.length;
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = nums[i];
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            for (int key : map.keySet()) {
                if(map.containsKey(key + 1)) {
                    res = Math.max(res, map.get(key + 1) + map.get(key));
                }
            }
            return res;
        }
    }
}
