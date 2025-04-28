public class lc2302 {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        long sum = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            sum += nums[right];
            //while (left <= right && sum * (right - left + 1) >= k) { 可以不用判断这个left <= right
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            res += left - right + 1;
            right++;
        }

        return res;
    }
}
