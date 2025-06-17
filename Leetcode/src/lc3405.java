public class lc3405 {
    class Solution {
        private static final int mod = 1000000007;
        private static final int mx = 100000;

        private static final long[] fac = new long[mx];
        private static final long[] invF = new long[mx];

        private boolean initialized = false;

        private void init() {
            if (initialized) {
                return;
            }

            initialized = true;

            fac[0] = 1;
            for (int i = 1; i < mx; i++) {
                fac[i] = fac[i - 1] * i % mod;
            }

            invF[mx - 1] = pow(fac[mx - 1], mod - 2);
            for (int i = mx - 1; i > 0; i--) {
                invF[i - 1] = invF[i] * i % mod;
            }
        }

        private long pow(long x, int n) {
            long res = 1;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = res * x % mod;
                }
                x = x * x % mod;
                n >>= 1;
            }
            return res;
        }

        private long comb(int n, int m) {
            return fac[n] * invF[m] % mod * invF[n - m] % mod;
        }


        public int countGoodArrays(int n, int m, int k) {
            init();
            return (int) (comb(n - 1, k) * m % mod * pow(m - 1, n - k - 1) % mod);
        }


    }
}
