import java.util.LinkedList;
import java.util.List;

public class lc440 {
//    class Solution {
//        List<Integer> arr = new LinkedList<>();
//
//        public int findKthNumber(int n, int k) {
//            for (int i = 1; i <= 9; i++) {
//                dfs(i, n);
//            }
//
//            return arr.get(k);
//        }
//
//        void dfs(int i, int n) {
//            if (i > n) return;
//            arr.add(i);
//            for (int k = 0; k <= 9; k++) {
//                dfs(i * 10 + k, n);
//            }
//        }
//    }


    class Solution {
        public int findKthNumber(int n, int k) {
            int node = 1;
            k--;
            while (k > 0) {
                int size = count(n, node);
                if (size <= k) {
                    node++;
                    k -= size;
                } else {
                    node *= 10;
                    k--;
                }
            }
            return node;
        }

        int count(int n, int node) {
            int size = 0;
            long right = node + 1;
            long left = node;
            while (left <= n) {
                size += Math.min(right, n + 1) - left;
                right *= 10;
                left *= 10;
            }
            return size;
        }
    }
}
