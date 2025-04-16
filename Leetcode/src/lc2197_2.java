/*
灵神的题解
树状数组还没学
 */

public class lc2197_2 {
    class FenwickTree {
        private final int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1]; // 使用下标 1 到 n
        }

        // a[i] 增加 val
        // 1 <= i <= n
        public void update(int i, long val) {
            for (; i < tree.length; i += i & -i) {
                tree[i] += val;
            }
        }

        // 求前缀和 a[1] + ... + a[i]
        // 1 <= i <= n
        public int pre(int i) {
            int res = 0;
            for (; i > 0; i &= i - 1) {
                res += tree[i];
            }
            return res;
        }
    }

    class Solution {
        public long goodTriplets(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[nums1[i]] = i;
            }

            long ans = 0;
            FenwickTree t = new FenwickTree(n);
            for (int i = 0; i < n - 1; i++) {
                int y = p[nums2[i]];
                int less = t.pre(y);
                ans += (long) less * (n - 1 - y - (i - less));
                t.update(y + 1, 1);
            }
            return ans;
        }
    }
}
