public class P12216 {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int a = (2023 * 6 / 7) * 16 / 17;
        long k = pow(2023, 2022);
        long res = k * a % mod;
        System.out.println(res);
    }

    static long pow(long a, long b) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
