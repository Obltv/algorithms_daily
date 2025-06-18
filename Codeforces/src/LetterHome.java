import java.util.Scanner;

public class LetterHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int min;
            int res;
            if (s <= arr[0]) {
                res = arr[n - 1] - s;
            } else if (s >= arr[n - 1]) {
                res = s - arr[0];
            } else {
                min = s - arr[0] >= arr[n - 1] - s ? (arr[n - 1] - s) : (s - arr[0]);
                res = min + arr[n - 1] - arr[0];
            }
            System.out.println(res);
        }
    }
}
