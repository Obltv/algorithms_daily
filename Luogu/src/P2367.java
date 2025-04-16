import java.util.Scanner;

public class P2367 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int[] a = new int[n + 5];
        int[] b = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            b[i] = a[i] - a[i - 1];
        }
        for (int i = 0; i < p; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            b[x] += z;
            b[y + 1] -= z;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + b[i];
            min = Math.min(min, a[i]);
        }

        System.out.println(min);

    }
}
