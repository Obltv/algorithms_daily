import java.util.Arrays;

public class lc354 {
    //经典dp,超时
//    class Solution {
//        public int maxEnvelopes(int[][] envelopes) {
//            Arrays.sort(envelopes, (int[] a, int[] b) -> {
//                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
//            });
//
//            int n = envelopes.length;
//            int[] dp = new int[n];
//            Arrays.fill(dp, 1);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (envelopes[i][1] > envelopes[j][1]) {
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//            }
//
//            int res = 0;
//            for (int i = 0; i < n; i++) {
//                res = Math.max(res, dp[i]);
//            }
//
//            return res;
//        }
//    }

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (int[] a, int[] b) -> {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            });

            int n = envelopes.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = envelopes[i][1];
            }

            return lis(nums);
        }

        int lis(int[] nums) {
            int n = nums.length;
            int[] top = new int[n];
            int size = 0;

            for (int i = 0; i < n; i++) {
                int x = nums[i];
                int left = 0;
                int right = size;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (top[mid] >= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                if (left == size)
                    size++;
                top[left] = x;
            }
            return size;
        }
    }
}
