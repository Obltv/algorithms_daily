import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc3341 {
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//
//    static boolean[][] memo;
//
//    static int time = 0;
//    static int res = Integer.MAX_VALUE;
//
//    public static int minTimeToReach(int[][] moveTime) {
//        memo = new boolean[moveTime.length][moveTime[0].length];
//        memo[0][0] = true;
//        dfs(0, 0, moveTime);
//        return res;
//    }
//
//    static void dfs(int n, int m, int[][] moveTime) {
//        if (n == moveTime.length - 1 && m == moveTime[0].length - 1) {
//            res = Math.min(res, time);
//            return;
//        }
//        for (int i = 0; i < 4; i++) {
//            int x = n + dx[i];
//            int y = m + dy[i];
//            if (x < 0 || y < 0 || x >= moveTime.length || y >= moveTime[0].length) {
//                continue;
//            } else {
//                if (memo[x][y]) {
//                    continue;
//                } else {
//                    memo[x][y] = true;
//                    int tmp = time;
//                    time = Math.max(moveTime[x][y], time) + 1;
//                    dfs(x, y, moveTime);
//                    time = tmp;
//                    memo[x][y] = false;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] moveTime = new int[][]{{0, 0, 0}, {0, 0, 0}};
//        minTimeToReach(moveTime);
//    }

    int[][] distTo;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int minTimeToReach(int[][] moveTime) {
        distTo = new int[moveTime.length][moveTime[0].length];
        for (int i = 0; i < moveTime.length; i++) {
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }
        distTo[0][0] = 0;
        dijkstra(0, 0, moveTime);
        return distTo[moveTime.length - 1][moveTime[0].length - 1];
    }

    class State {
        int x;
        int y;
        int distFromStart;

        public State(int x, int y, int distFromStart) {
            this.x = x;
            this.y = y;
            this.distFromStart = distFromStart;
        }
    }

    void dijkstra(int a, int b, int[][] moveTime) {
        Queue<State> q = new PriorityQueue<>((m, n) -> (m.distFromStart - n.distFromStart));
        q.offer(new State(a, b, 0));
        while (!q.isEmpty()) {
            State cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int distFrom = cur.distFromStart;
            if (distFrom > distTo[curX][curY]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextX >= moveTime.length || nextY < 0 || nextY >= moveTime[0].length) {
                    continue;
                }
                int newDist = Math.max(distFrom, moveTime[nextX][nextY]) + 1;
                if (newDist < distTo[nextX][nextY]) {
                    distTo[nextX][nextY] = newDist;
                    q.offer(new State(nextX, nextY, newDist));
                }
            }
        }
    }
}
