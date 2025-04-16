import java.io.*;

public class P2367_2 {
    static final int SIZE = 5000005;
    static int[] diff = new int[SIZE];

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int p = in.nextInt();

        int prev = 0;
        for (int i = 1; i <= n; i++) {
            int now = in.nextInt();
            diff[i] = now - prev;
            prev = now;
        }

        while (p-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            diff[x] += z;
            if (y + 1 < SIZE) diff[y + 1] -= z;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += diff[i];
            if (sum < min) min = sum;
        }

        System.out.println(min);
    }

    static class InputReader {
        BufferedReader reader;
        char[] buffer = new char[1 << 16];
        int cur, num;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = reader.read();
            } while (c <= 32);
            int res = 0, sign = 1;
            if (c == '-') {
                sign = -1;
                c = reader.read();
            }
            do {
                res = res * 10 + (c - '0');
                c = reader.read();
            } while (c > 32);
            return res * sign;
        }
    }
}