import java.util.Comparator;
import java.util.PriorityQueue;

public class lc2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1;
        int maxI = -1;
        int i0 = -1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (nums[i] == minK) {
                minI = i;
            }
            if (nums[i] == maxK) {
                maxI = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                i0 = i;
            }
            res += Math.max(Math.min(minI, maxI) - i0, 0);
        }
        return res;
    }
}
