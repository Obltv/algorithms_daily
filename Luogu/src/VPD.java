import java.util.Scanner;

public class VPD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = dp(n, m);
        System.out.println(res);
    }

    static int dp(int n, int m) {
        if (n >= m) return n - m;

        if (m % 2 == 0) {
            if (m / 2 < n) {
                return 1 + n - m / 2;
            } else {
                return dp(n, m / 2) + 1;
            }
        } else {
            return dp(n, m + 1) + 1;
        }
    }

}
