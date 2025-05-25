public class lc0525Q1 {
    public long minCuttingCost(int n, int m, int k) {
        if (k > m && k > n) return 0;
        if (m > n) {
            return (long) (m - k) * k;
        } else {
            return (long) (n - k) * k;
        }
    }
}
