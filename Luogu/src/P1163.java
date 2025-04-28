import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class P1163 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        BigInteger w0 = new BigInteger(scan.next());
//        BigInteger w1 = new BigInteger(scan.next());
//        BigInteger m = new BigInteger(scan.next());
//
//        BigInteger a = w0.multiply(m);
//        BigInteger b = (w1.subtract(a).multiply(a));
//        BigInteger c = new BigInteger("100");
//        b.multiply(c);
//        System.out.print(b + "%");
//
//    }


    static double m, y;
    static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextDouble();
        y = sc.nextDouble();
        t = sc.nextInt();
        solve(0, 5);
    }

    static void solve(double l, double r) {
        double mid = (l + r) / 2;
        double diff = r - l;
        if (diff < 0.0001) {
            out(mid);
        }
        double a = m;
        for (int i = 1; i <= t; i++) {
            a = a * (1 + mid) - y;
        }
        if (a > 0) {
            solve(l, mid);
        } else if (a < 0) {
            solve(mid, r);
        } else {
            out(mid);
        }
    }

    static void out(double rate) {
        double ans = rate * 100;
        BigDecimal res = new BigDecimal(ans).setScale(1, RoundingMode.HALF_UP);
        System.out.println(res);
        System.exit(0);
    }


}
