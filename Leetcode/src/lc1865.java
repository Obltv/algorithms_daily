import java.util.HashMap;
import java.util.Map;

public class lc1865 {
    class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;

            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
        }

        public void add(int index, int val) {
            map.put(nums2[index], map.get(nums2[index]) - 1);
            map.put(nums2[index] + val, map.getOrDefault(nums2[index] + val, 0) + 1);
            nums2[index] += val;
        }

        public int count(int tot) {
            int res = 0;
            for (int i = 0; i < nums1.length; i++) {
                int l = tot - nums1[i];
                if (map.containsKey(l)) {
                    res += map.get(l);
                }
            }
            return res;
        }
    }

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
}
