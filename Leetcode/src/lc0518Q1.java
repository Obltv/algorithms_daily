public class lc0518Q1 {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == wei(nums[i])) {
                return i;
            }
        }
        return -1;
    }

    public int wei(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
