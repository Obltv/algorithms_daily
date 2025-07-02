import java.util.Scanner;

public class cf1035C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            int[] arr2 = new int[n + 1];
            int[] arr5 = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            int min1 = arr[1];
            for (int i = 1; i <= n; i++) {
                arr2[i] = min1;
                min1 = Math.min(min1, arr[i]);
            }

            int max2 = arr[n];
            for (int i = n; i >= 1; i--) {
                arr5[i] = max2;
                max2 = Math.max(max2, arr[i]);
            }

            for (int i = 1; i <= n; i++) {
                int res = 0;

                if (arr[i] <= arr2[i]) {
                    res = 1;
                }
                if (arr[i] >= arr5[i]) {
                    res = 1;
                }

                arr[i] = res;
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
