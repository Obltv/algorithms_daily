import java.util.Arrays;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int min = nums.length;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ints[i]) {
                min = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != ints[i]) {
                max = i;
                break;
            }
        }
        return min-max==nums.length?0:max-min+1;
    }
}
