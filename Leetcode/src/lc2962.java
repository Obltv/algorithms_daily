import java.util.ArrayList;
import java.util.List;

public class lc2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int right = 0;
        int left = 0;
        int count = 0;
        long res = 0;
        while (right < nums.length) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            res += left;
            right++;
        }
        return res;
    }
}
