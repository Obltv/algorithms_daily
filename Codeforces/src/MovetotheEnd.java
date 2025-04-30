import java.util.ArrayDeque;
import java.util.Scanner;

public class MovetotheEnd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            int[] arr1 = new int[n];
            arr[0] = scan.nextInt();
            arr1[0] = arr[0];
            for (int i = 1; i < n; i++) {
                arr[i] = scan.nextInt();
                arr1[i] = Math.max(arr[i], arr1[i - 1]);
            }

            long[] sum = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                sum[i] = sum[i + 1] + arr[i];
            }

            for (int i = 0; i < n; i++) {
                long res = arr1[n - i - 1] + sum[n - i];
                System.out.print(res + " ");
            }
            System.out.println();
        }

    }
}
