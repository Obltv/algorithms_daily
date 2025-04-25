public class lc862 {
    public int shortestSubarray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minWin = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= k) {
                sum -= nums[left];
                left++;
                minWin = Math.min(minWin, right - left + 2);
            }
            right++;
        }
        return minWin == Integer.MAX_VALUE ? -1 : minWin;
    }
}
