import java.util.*;

public class NC0716A {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long ans = 0;
        long[] fac = new long[m + 1];
        fac[0] = 1;
        for (int i = 1; i <= m; i++) {
            fac[i] = fac[i - 1] * i % MOD;
        }

        for (int k = 0; k <= m; k++) {
            long sign = (k % 2 == 0) ? 1 : -1;
            long comb = fac[m] * modInverse(fac[k], MOD) % MOD * modInverse(fac[m - k], MOD) % MOD;
            long pow = fastPow(m - k, n, MOD);
            ans = (ans + sign * comb % MOD * pow % MOD + MOD) % MOD;
        }

        System.out.println(ans);
    }

    static long fastPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    static long modInverse(long a, int mod) {
        return fastPow(a, mod - 2, mod);
    }
}
