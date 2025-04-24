import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int k = set.size();
        int right = 0;
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() >= k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += left;
            right++;
        }
        return res;
    }
}
