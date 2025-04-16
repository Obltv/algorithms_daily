import java.util.Scanner;

public class P8647 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }

        int left = 1;
        int right = (int) 1e5;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int res = fen(mid, a, b);
            if (res >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    public static int fen(int mid, int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] / mid) * (b[i] / mid);
        }
        return sum;
    }
}
