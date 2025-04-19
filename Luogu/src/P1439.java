import java.util.Scanner;

public class P1439 {
    public static int[] mr;

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        int[] b = new int[n + 1];
        mr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr1[i] = scan.nextInt();
            b[arr1[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] = scan.nextInt();
            arr2[i] = b[arr2[i]];
        }

        int res = 0;
        int ma = 0;
        for (int i = 1; i <= n; i++) {
            int l = fen(arr2[i], ma) + 1;
            res = Math.max(res, l);
            mr[l] = mr[l] == 0 ? arr2[i] : Math.min(arr2[i], mr[l]);
            ma = Math.max(ma, l);
        }

        System.out.println(res);
        scan.close();
    }

    public static int fen(int target, int ma) {
        int l = 0;
        int r = ma;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
