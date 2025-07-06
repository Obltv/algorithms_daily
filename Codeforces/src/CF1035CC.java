import java.util.Scanner;

public class CF1035CC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();

            if (n % 2 == 1) {
                System.out.println(l);
            } else if (n == 2) {
                System.out.println(-1);
            } else {
                long next = Long.highestOneBit(l) << 1;
                if (next > r) {
                    System.out.println(-1);
                } else {
                    if (k <= n - 2) {
                        System.out.println(l);
                    } else {
                        System.out.println(next);
                    }
                }
            }
        }
    }
}
