public class lc3542 {
    public int minOperations(int[] nums) {
        int res = 0;
        int p = -1;
        for (int x : nums) {
            while (p >= 0 && x < nums[p]) {
                res++;
                p--;
            }
            if (p < 0 || x > nums[p]) {
                nums[++p] = x;
            }
        }
        return res + p + (nums[0] == 0 ? 0 : 1);
    }
}
