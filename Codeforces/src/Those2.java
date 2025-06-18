import java.io.*;
import java.util.*;

public class Those2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int max = 0;
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == max) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            if (list.size() > 2) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        int r = list.get(i)[0];
                        int c = list.get(j)[1];
                        int cur = Integer.MIN_VALUE;
                        for (int p = 0; p < n; p++) {
                            for (int q = 0; q < m; q++) {
                                int value = arr[p][q];
                                if (p == r || q == c) value--;
                                cur = Math.max(cur, value);
                            }
                        }
                        res = Math.min(cur, res);
                    }
                }
                System.out.println(res);
            } else {
                System.out.println(max - 1);
            }
        }
    }
}
