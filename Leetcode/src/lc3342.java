import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc3342 {
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
            int curDist = cur.distFromStart;
            if (curDist > distTo[curX][curY]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextX >= moveTime.length || nextY < 0 || nextY >= moveTime[0].length) {
                    continue;
                }
                int nextDist = Math.max(curDist, moveTime[nextX][nextY]) + ((nextX + nextY) % 2 == 0 ? 2 : 1);
                if (nextDist < distTo[nextX][nextY]) {
                    distTo[nextX][nextY] = nextDist;
                    q.offer(new State(nextX, nextY, nextDist));
                }
            }
        }
    }
}
