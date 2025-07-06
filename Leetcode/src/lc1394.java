public class lc1394 {
    class Solution {
        public int findLucky(int[] arr) {
            int[] b = new int[501];
            for (int i = 0; i < arr.length; i++) {
                b[arr[i]]++;
            }

            for (int i = 500; i >= 1; i--) {
                if (b[i] == i) {
                    return i;
                }
            }

            return -1;
        }
    }
}
