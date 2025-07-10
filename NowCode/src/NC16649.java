import java.util.Scanner;

public class NC16649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[l + 5];

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a]--;
            arr[b + 1]++;
        }

        int res = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i <= l; i++) {
            arr[i] = arr[i - 1] + arr[i];
            if (arr[i] == 0) {
                res++;
            }
        }

        System.out.println(res);
    }
}
