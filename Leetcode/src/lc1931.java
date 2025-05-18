import java.util.LinkedList;
import java.util.Queue;

public class lc1931 {
    int mod = 1000000007;
    int res = 0;
    int count = 0;
    int size;
    boolean[] visited;
    int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int colorTheGrid(int m, int n) {
        int[][] map = new int[m][n];
        visited = new boolean[size];
        size = m * n;
        bfs(map, 0, 0, m, n);
        return res;
    }

    void bfs(int[][] map, int x, int y, int m, int n) {
        if (count == size) {
            res++;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            q.offer(new Node(x, y, i));
            while (!q.isEmpty()) {
                Node node = q.poll();
                int a = node.x;
                int b = node.y;
                int color = node.color;
                for (int j = 0; j < 3; j++) {
                    visited[a * m + b] = true;
                    for (int k = 0; k < 4; k++) {
                        int newA = a + d[i][0];
                        int newB = b + d[i][1];

                    }
                }
            }
        }


    }

    class Node {
        int x;
        int y;
        int color;

        public Node(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
