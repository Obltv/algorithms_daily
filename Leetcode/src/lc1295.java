public class lc1295 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            String s = String.valueOf(num);
            if (s.length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
