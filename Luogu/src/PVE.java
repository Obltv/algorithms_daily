import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PVE {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (n == 2) {
                if (arr[0] < arr[1]) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            int res = arr[0] < arr[1] ? 1 : 0;
            int[] min = new int[n];
            min[0] = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                min[i] = Math.min(min[i - 1], arr[i - 1]);
            }

            for (int i = 2; i < n; i++) {
                if (arr[i] < min[i]) {
                    continue;
                } else {
                    if (i % 2 == 0) {
                        if (arr[0] > arr[1]) {
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

}
