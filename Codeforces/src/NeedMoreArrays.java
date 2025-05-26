import java.util.Scanner;

public class NeedMoreArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                arr2[i] = arr[i];
            }

            int right = 1;
            int left = 0;
            while (right < n) {
                while (arr[left] + 1 >= arr[right]) {
                    arr2[right] = -1;
                    right++;
                    if (right >= n) break;
                }
                left = right;
                right++;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (arr2[i] != -1) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
