import java.util.Arrays;
import java.util.Scanner;

public class NC16593 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int len = 1000000;
//        int[][] map = new int[200][200];
//        for (int[] m : map) {
//            Arrays.fill(m, -1);
//        }
//
//        for (int i = 1; i <= n; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int g = sc.nextInt();
//            int k = sc.nextInt();
//
//            for (int r = a; r <= a + g; r++) {
//                for (int j = b; j <= b + k; j++) {
//                    map[r][j] = i;
//                }
//            }
//        }
//
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//
//        System.out.println(map[x][y]);
//
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][4];
        for (int i = 0; i < n; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
            map[i][3] = sc.nextInt();
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            if (map[i][0] <= x && map[i][1] <= y && x <= map[i][0] + map[i][2] && y <= map[i][1] + map[i][3]) {
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(-1);

    }
}
