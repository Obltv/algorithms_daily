import java.util.Scanner;

public class NC0630A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (a == 0 && b == 0) {
                System.out.println(1L * n);
                continue;
            }
            if (a != 0 && b == 0) {
                System.out.println(1L * n * a);
                continue;
            }

            long k1 = (a - 1 + n * b) / (2 * b);
            long k2 = k1 + 1;
            long res1;
            long res2;


            if (k1 < n) {
                res1 = -(1L * b * k1 * k1) + (1L * a - 1 + n * b) * k1 + n;
            } else {
                res1 = 1L * n * a;
            }
            if (k2 < n) {
                res2 = -(1L * b * k2 * k2) + (1L * a - 1 + n * b) * k2 + n;
            } else {
                res2 = 1L * n * a;
            }


            long res;
            if (res1 > res2) {
                res = res1;
            } else {
                res = res2;
            }

            System.out.println(res);
        }
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            long n = sc.nextLong();
//            long a = sc.nextLong();
//            long b = sc.nextLong();
//
//            if (a == 0 && b == 0) {
//                System.out.println(1L * n);
//                continue;
//            }
//            if (a != 0 && b == 0) {
//                System.out.println(1L * n * a);
//                continue;
//            }
//
//            long k1 = Math.max(0, (a - 1 + n * b) / (2 * b));
//            long k2 = k1 + 1;
//            long res1;
//            long res2;
//
//            if (k1 < n) {
//                res1 = -(1L * b * k1 * k1) + (1L * a - 1 + n * b) * k1 + n;
//            } else {
//                res1 = 1L * n * a;
//            }
//            if (k2 < n) {
//                res2 = -(1L * b * k2 * k2) + (1L * a - 1 + n * b) * k2 + n;
//            } else {
//                res2 = 1L * n * a;
//            }
//
//            long res = Math.max(res1, res2);
//            System.out.println(res);
//        }
//    }
//}

