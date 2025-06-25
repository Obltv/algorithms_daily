import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class lc2200 {
    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    s(nums, i, set, k);
                }
            }

            List<Integer> res = new LinkedList<>(set);
            return res;
        }

        void s(int[] nums, int i, TreeSet set, int k) {
            for (int j = i - k; j <= i + k; j++) {
                if (j < 0)
                    continue;
                if (j >= nums.length)
                    return;
                set.add(j);
            }
        }
    }
}
