import java.util.Scanner;

public class Retaliation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            boolean flag = true;
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            int cha = arr[2] - arr[1];
            if (cha >= 0 && cha > arr[1]) {
                flag = false;
            }
            if (cha < 0 && Math.abs(cha) > arr[n]) {
                flag = false;
            }

            for (int i = 3; i <= n; i++) {
                if (arr[i] - arr[i - 1] != cha) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int i = 1; i <= n; i++) {
                    if (cha >= 0) {
                        arr[i] -= i * cha;
                    } else {
                        arr[i] -= (n - i + 1) * Math.abs(cha);
                    }
                }
                if (arr[1] % (n + 1) == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
