import java.util.Scanner;

public class CF1035A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int res = 0;

            if (a == b) {
                System.out.println(0);
                continue;
            }

            if (a > b) {
                if (a % 2 == 0) {
                    System.out.println(-1);
                } else if (a == b + 1) {
                    res = y;
                    System.out.println(res);
                }else{
                    System.out.println(-1);
                }
                continue;
            }

            while (a < b) {
                if (a % 2 == 0) {
                    if (y < x) {
                        a = a ^ 1;
                        res += y;
                    } else {
                        a += 1;
                        res += x;
                    }
                } else {
                    a += 1;
                    res += x;
                }
            }

            if (a == b) {
                System.out.println(res);
            } else {
                System.out.println(-1);
            }

        }
    }
}
