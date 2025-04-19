import java.util.Scanner;

public class P1216 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int[][] arr = new int[r][r];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scan.nextInt();
                if (j == 0) {
                    if (i != 0) {
                        arr[i][j] += arr[i - 1][j];
                    }
                } else {
                    arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
                res = Math.max(res, arr[i][j]);
            }
        }
        System.out.println(res);
    }
}
