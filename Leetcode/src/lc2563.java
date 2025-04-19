import java.util.Arrays;

public class lc2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j1 = fen(nums, lower - nums[i], i);
            int j2 = fen(nums, upper - nums[i] + 1, i);
            res += j2 - j1;
        }
        return res;
    }

    public int fen(int[] nums, int a, int i) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

//    public int fen2(int[] nums, int a) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] >= a) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return right;
//    }
}
