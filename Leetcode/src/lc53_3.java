public class lc53_3 {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int window = 0;
        int res = Integer.MIN_VALUE;

        while (right < nums.length) {
            window += nums[right];
            right++;

            res = Math.max(res, window);

            while (window < 0) {
                window -= nums[left];
                left++;
            }
        }
        return res;
    }
}
