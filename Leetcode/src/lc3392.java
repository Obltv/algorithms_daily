public class lc3392 {
    public int countSubarrays(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] % 2 == 1 || nums[i - 1] % 2 == -1) {
                continue;
            }
            if (nums[i - 2] + nums[i] == (nums[i - 1] / 2)) {
                res++;
            }
        }
        return res;
    }

}
