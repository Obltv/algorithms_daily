import java.util.Arrays;

public class lc494 {
    class Solution {
        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, 0, target);
            return res;
        }

        void dfs(int[] nums, int start, int target) {
            if (start == nums.length) {
                if (target == 0) {
                    res++;
                }
                return;
            }

            target -= nums[start];
            dfs(nums, start + 1, target);
            target += nums[start];

            target += nums[start];
            dfs(nums, start + 1, target);
            target -= nums[start];

        }
    }

    class Solution2 {
        int[][] memo;

        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            memo = new int[n + 1][4040];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
            return dp(nums, 0, target);
        }

        int dp(int[] nums, int i, int target){
            if(i==nums.length){
                if(target==0){
                    return 1;
                }
                return 0;
            }

            if(memo[i][target+2000]!=-1){
                return memo[i][target+2000];
            }

            return memo[i][target+2000]=dp(nums, i+1, target-nums[i])+dp(nums, i+1, target+nums[i]);
        }
    }
}
