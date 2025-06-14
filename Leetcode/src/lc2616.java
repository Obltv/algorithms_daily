import java.util.Arrays;

public class lc2616 {
    class Solution {
        public int minimizeMax(int[] nums, int p) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums[nums.length - 1] - nums[0];
            while (left <= right) {
                int mid = (left + right) >> 1;

                if (check(nums, mid, p)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        boolean check(int[] nums, int mx, int p) {
            int cnt = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] <= mx) {
                    cnt++;
                    i++;
                }
            }

            return cnt >= p;
        }
    }
}
