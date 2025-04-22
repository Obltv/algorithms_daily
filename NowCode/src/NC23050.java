import java.util.Scanner;

public class NC23050 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        String n = scan.next();

        long res = gcd(a, b);
        System.out.println(res);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
