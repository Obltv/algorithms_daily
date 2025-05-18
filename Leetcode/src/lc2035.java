public class lc2035 {
    int ans1 = 0;
    int min = Integer.MAX_VALUE;
    int sum = 0;
    int count = 0;

    public int minimumDifference(int[] nums) {
        for (int num : nums) {
            sum += num;
        }
        dfs(nums, 0);
        return min;
    }

    void dfs(int[] nums, int n) {
        if (count == nums.length / 2) {
            if (Math.abs((sum - ans1) - ans1) < min) {
                min = Math.abs((sum - ans1) - ans1);
            }
            return;
        }

        for (int i = n; i < nums.length; i++) {
            count++;
            ans1 += nums[i];
            dfs(nums, i + 1);
            ans1 -= nums[i];
            count--;
        }
    }
}
