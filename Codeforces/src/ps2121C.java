import java.util.Scanner;

public class ps2121C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][m];
            int[] row = new int[n];
            int[] col = new int[m];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                    max = Math.max(map[i][j], max);
                }
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == max) {
                        total++;
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int cur = map[i][j] == max ? 0 : 1;
                    int res1 = row[i] + col[j] - 1 + cur;
                    if (res1 == total) {
                        flag = true;
                    }
                }
            }
            if (!flag) {
                System.out.println(max);
            }else{
                System.out.println(max-1);
            }
        }

    }
}
