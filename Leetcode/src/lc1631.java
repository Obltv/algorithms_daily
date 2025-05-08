import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc1631 {
    int[][] distTo;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int minimumEffortPath(int[][] heights) {
        distTo = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }
        distTo[0][0] = 0;
        dijkstra(0, 0, heights);
        return distTo[heights.length - 1][heights[0].length - 1];
    }

    class State {
        int distFromStart;
        int x;
        int y;

        public State(int x, int y, int distFromStart) {
            this.distFromStart = distFromStart;
            this.x = x;
            this.y = y;
        }
    }

    void dijkstra(int u, int v, int[][] moveTime) {
        Queue<State> q = new PriorityQueue<>((m, n) -> m.distFromStart - n.distFromStart);
        q.offer(new State(u, v, 0));
        while (!q.isEmpty()) {
            State cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curDistFrom = cur.distFromStart;
            if (curDistFrom > distTo[curX][curY]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextX >= moveTime.length || nextY < 0 || nextY >= moveTime[0].length) {
                    continue;
                }
                int effortToNextNode = Math.max(
                        distTo[curX][curY],
                        Math.abs(moveTime[nextX][nextY] - moveTime[curX][curY])
                );
                if (effortToNextNode < distTo[nextX][nextY]) {
                    distTo[nextX][nextY] = effortToNextNode;
                    q.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
    }
}
