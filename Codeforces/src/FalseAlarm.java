import java.util.Scanner;

public class FalseAlarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            int size = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                size += arr[i] == 1 ? 1 : 0;
            }
            int right = -1;
            int left = n;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    right = i;
                    break;
                }
            }
            for (int i = n - 1; i > 0; i--) {
                if (arr[i] == 1) {
                    left = i;
                    break;
                }
            }

            int time = left - right + 1;
            if (size == 0) {
                time = 0;
            }
            if (size == 1) {
                time = 1;
            }
            if (x >= time) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
