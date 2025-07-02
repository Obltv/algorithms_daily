import java.math.BigInteger;
import java.util.Scanner;

public class NC0630H {
//    static long MOD = 998244353L;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            long n = sc.nextLong();
//            if (n == 1) {
//                System.out.println(1);
//                continue;
//            }
//            if (n % 2 == 1) {
//                long m = (n / 2 + 1) ;
//                long res = ((long) (Math.pow(4, m)) / 3) % MOD;
//                System.out.println(res);
//            } else {
//                long m = ((n - 1) / 2 + 1) ;
//                long res = ((long) (Math.pow(4, m)) / 3) % MOD;
//                res = res * 2 % MOD;
//                System.out.println(res);
//            }
//        }
//    }

    public class Main{
        private static final long mod = 998244353;
        public static long fastpow(long a, long b, long mod) {
            long res = 1;
            a %= mod;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = (res * a) % mod;
                }
                a = (a * a) % mod;
                b >>= 1;
            }
            return res;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            long inv3 = fastpow(3, mod-2, mod);
            while (t-- > 0) {
                long n = sc.nextLong();
                long a = fastpow(2, n+1, mod);
                long r = (n % 2 == 0) ? 1 : 0;
                long b = (a - 1 - r) % mod;
                if (b < 0) b += mod;
                long ans = (b * inv3) % mod;
                System.out.println(ans);
            }
        }
    }

}

