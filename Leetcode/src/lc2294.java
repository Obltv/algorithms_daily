import java.util.Arrays;

public class lc2294 {
    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);

            int left = 0;
            int right = 0;
            int n = nums.length;
            int res = 0;
            while (right < n) {
                while (right < n && (nums[right] - nums[left] <= k)) {
                    right++;
                }
                res++;
                left = right;
            }

            return res;
        }
    }
}
