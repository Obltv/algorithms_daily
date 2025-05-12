public class lc1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[right] % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count == 3) {
                    return true;
                }
            }
            right++;
        }
        return false;
    }
}
