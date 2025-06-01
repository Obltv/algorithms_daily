import java.util.ArrayDeque;
import java.util.Deque;

public class lc909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int m = q.poll();
                if (m == n * n)
                    return res;
                for (int i = m + 1; i <= Math.min(m + 6, n * n); i++) {
                    int r = (i - 1) / n;
                    int c = (i - 1) % n;
                    if (r % 2 == 1) {
                        c = n - 1 - c;
                    }
                    int next = board[n - 1 - r][c];
                    if (next < 0) {
                        next = i;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }

}