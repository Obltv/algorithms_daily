import java.util.Arrays;
import java.util.HashMap;

public class lc2099 {
    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int n = nums.length;
            int[] nums2 = Arrays.copyOf(nums, n);
            Arrays.sort(nums);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = n - k; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            int[] res = new int[k];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums2[i])) {
                    res[index++] = nums2[i];
                    int a = map.get(nums2[i]);
                    if (a == 1) {
                        map.remove(nums2[i]);
                    } else {
                        map.put(nums2[i], a - 1);
                    }
                }
            }

            return res;
        }
    }
}
