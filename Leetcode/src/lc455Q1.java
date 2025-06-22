import java.util.Arrays;

public class lc455Q1 {
    static class Solution {
        public boolean checkPrimeFrequency(int[] nums) {
            int n = nums.length;
            int[] arr = new int[105];
            Arrays.fill(arr, -1);
            for (int i = 0; i < n; i++) {
                arr[nums[i]]++;
            }

            boolean res = false;
            for (int i = 0; i < 105; i++) {
                if (arr[i] == -1) continue;
                if (isP(arr[i])) {
                    res = true;
                    break;
                }
            }

            return res;
        }

        boolean isP(int a) {
            if (a < 2) return false;
            if (a == 2) return true;
            for (int i = 3; i < a; i += 2) {
                if (a % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,0,3,3,6,3};
        Solution s=new Solution();
        s.checkPrimeFrequency(arr);

    }
}
