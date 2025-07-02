import java.util.Scanner;

public class cf1034B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            int max = 0;
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }

            int target = arr[j];

            if (k == 1 && max != target) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
}
