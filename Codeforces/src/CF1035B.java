import java.util.Arrays;
import java.util.Scanner;

public class CF1035B {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int px = sc.nextInt();
//            int py = sc.nextInt();
//            int qx = sc.nextInt();
//            int qy = sc.nextInt();
//
//            int x = px - qx;
//            int y = py - qy;
//
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//            Arrays.sort(arr);
//
//            double sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += arr[i];
//            }
//
//            double s = Math.sqrt(x * x + y * y);
//
//            if (sum < s) {
//                System.out.println("NO");
//                continue;
//            }
//
//            if (Math.abs(sum - s) < 1e-9) {
//                System.out.println("YES");
//                continue;
//            }
//
//
//            int max = arr[arr.length - 1];
//            double k = Math.max(0, max - (sum - max));
//
//            if (sum > s) {
//                if (k > s) {
//                    System.out.println("NO");
//                } else {
//                    System.out.println("YES");
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int px = sc.nextInt();
            int py = sc.nextInt();
            int qx = sc.nextInt();
            int qy = sc.nextInt();

            double[] a = new double[n];
            double sum = 0, max = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextDouble();
                sum += a[i];
                if (a[i] > max) max = a[i];
            }

            double dx = qx - px;
            double dy = qy - py;
            double d = Math.sqrt(dx * dx + dy * dy);

            double k = Math.max(0, max - (sum - max));

            if (sum + 1e-8 < d) {
                System.out.println("No");
            } else if (k -d > 1e-8) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
