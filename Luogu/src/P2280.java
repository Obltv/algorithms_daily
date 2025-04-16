import java.util.Scanner;

public class P2280 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int m = scan.nextInt();
        int n = 5001;
        int[][] map = new int[n + 2][n + 2];

        for (int i = 0; i < k; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            map[x + 1][y + 1] += z;
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                map[i][j] += map[i][j - 1];
//            }
//        }
//        for (int j = 1; j <= n; j++) {
//            for (int i = 1; i <= n; i++) {
//                map[i][j] += map[i - 1][j];
//            }
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + map[i][j];
            }
        }

        int res = 0;
        for (int i = m; i <= n; i++) {
            for (int j = m; j <= n; j++) {
                int ans = map[i][j] - map[i][j - m] - map[i - m][j] + map[i - m][j - m];
                res = Math.max(res, ans);
            }
        }
        System.out.println(res);
    }
}
