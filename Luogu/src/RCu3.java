import java.util.Scanner;

public class RCu3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int indexX = 0;
        int indexY = 0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        char[][] map = new char[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String line = scan.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        boolean[][] visited = new boolean[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 'c') {
                    indexX = i;
                    indexY = j;
                }
                if (map[i][j] == 'w') {
                    for (int p = i - 1; p <= i + 1; p++) {
                        for (int q = j - 1; q <= j + 1; q++) {
                            if (map[p][q] == 'm') {
                                visited[i][j] = true;
                                break;
                            }
                        }
                        if (visited[i][j]) {
                            break;
                        }
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 'w' && visited[i][j] != true) {
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (map[x][y] == '.' && check(x, y, map, indexX, indexY)) {
                                flag = true;
                                System.out.println(x + " " + y);
                            }
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag == false) {
            System.out.println("Too cold!");
        }
    }

    static boolean check(int i, int j, char[][] map, int x, int y) {
        for (int m = x - 1; m <= x + 1; m++) {
            for (int n = y - 1; n <= y + 1; n++) {
                if (m == i && n == j) {
                    return false;
                }
            }
        }
        return true;
    }
}
