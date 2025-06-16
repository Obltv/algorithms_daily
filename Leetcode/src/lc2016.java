public class lc2016 {
    class Solution {
        public int maximumDifference(int[] nums) {
            int res = -1;
            int max = nums[nums.length - 1];
            int index = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                int a = nums[i];
                if (max > a) {
                    int num = max - a;
                    if (num > res) {
                        res = num;
                    }
                } else {
                    max = a;
                }
            }

            return res;
        }
    }
}
