//import java.util.Scanner;
//
//public class gym10593D {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int q = sc.nextInt();
//            long[] a = new long[n + 1];
//            for (int i = 0; i < q; i++) {
//                int a1 = sc.nextInt();
//                int b1 = sc.nextInt();
//                long x = a1 / n;
//                int y = a1 % n;
//
//                a[0] += x;
//                a[n] -= x;
//
//                if (y > 0) {
//                    int k = b1 + y - 1;
//                    if (k < n) {
//                        a[b1]++;
//                        a[k + 1]--;
//                    } else {
//                        a[b1]++;
//                        a[n]--;
//                        a[0]++;
//                        a[k % n + 1]--;
//                    }
//                }
//            }
//
//            System.out.println(a[0] + " ");
//            for (int i = 1; i < n; i++) {
//                a[i] += a[i - 1];
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
//        }
//    }
//}

import java.util.Scanner;

public class gym10593D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] a = new long[n + 1];

            for (int i = 0; i < q; i++) {
                long a1 = sc.nextLong(); // 改为 long 读入
                int b1 = sc.nextInt();

                long x = a1 / n;
                int y = (int)(a1 % n);

                a[0] += x;
                a[n] -= x;

                if (y > 0) {
                    int k = b1 + y - 1;
                    if (k < n) {
                        a[b1]++;
                        a[k + 1]--;
                    } else {
                        a[b1]++;
                        a[n]--;
                        a[0]++;
                        a[(k % n) + 1]--;
                    }
                }
            }

            System.out.print(a[0]);
            for (int i = 1; i < n; i++) {
                a[i] += a[i - 1];
                System.out.print(" " + a[i]);
            }
            System.out.println();
        }
    }
}
