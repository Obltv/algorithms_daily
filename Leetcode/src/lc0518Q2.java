public class lc0518Q2 {
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = wei(nums[i]);
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
