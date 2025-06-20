import java.util.Arrays;

public class lc2966 {
    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int m = n / 3;
            int[][] res = {};
            boolean flag = true;
            for (int i = 0; i < n; i += 3) {
                if (nums[i + 2] - nums[i] > k) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return res;
            } else {
                res = new int[m][3];
                for (int i = 0; i < n; i++) {
                    int u = i / 3;
                    int v = i % 3;
                    res[u][v] = nums[i];
                }
                return res;
            }
        }
    }
}
