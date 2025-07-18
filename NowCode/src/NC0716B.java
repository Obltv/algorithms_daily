import java.util.Arrays;
import java.util.Scanner;

public class NC0716B {
    static int c1, c2, c3;
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            c1 = sc.nextInt();
            c2 = sc.nextInt();
            c3 = sc.nextInt();
            memo = new long[20005];
            Arrays.fill(memo, -1);

            long res = dp(a, b);
            System.out.println(res);
        }
    }

    static long dp(int a, int b) {
        if (a >= b) {
            return memo[a] = (long) (a - b) * c2;
        }
        if (memo[a] != -1) {
            return memo[a];
        }

        long res = (long) (b - a) * c1;

        res = Math.min(res, dp(a + 1, b) + c1);

        if (a > 1) {
            res = Math.min(res, dp(a - 1, b) + c2);
        }

        res = Math.min(res, dp(a * 2, b) + c3);

        return memo[a] = res;
    }


}
