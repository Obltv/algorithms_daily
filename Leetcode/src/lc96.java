public class lc96 {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return numTree(1, n);
    }

    int numTree(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = numTree(lo, mid - 1);
            int right = numTree(mid + 1, hi);
            res += right * left;
        }
        return memo[lo][hi] = res;
    }
}