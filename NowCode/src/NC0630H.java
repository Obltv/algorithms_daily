import java.math.BigInteger;
import java.util.Scanner;

public class NC0630H {
    static long MOD = 998244353L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            if (n % 2 == 1) {
                long m = (n / 2 + 1) ;
                long res = ((long) (Math.pow(4, m)) / 3) % MOD;
                System.out.println(res);
            } else {
                long m = ((n - 1) / 2 + 1) ;
                long res = ((long) (Math.pow(4, m)) / 3) % MOD;
                res = res * 2 % MOD;
                System.out.println(res);
            }
        }
    }

}

