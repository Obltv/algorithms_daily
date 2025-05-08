import java.util.*;

public class lc743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }

        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State {
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    int[] dijkstra(int k, List<int[]>[] graph) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[k] = 0;
        Queue<State> q = new PriorityQueue<>((a, b) -> (a.distFromStart - b.distFromStart));
        q.offer(new State(k, 0));
        while (!q.isEmpty()) {
            State cur = q.poll();
            int curId = cur.id;
            int curDistFrom = cur.distFromStart;
            if (curDistFrom > distTo[curId]) {
                continue;
            }
            for (int[] neighbor : graph[curId]) {
                int nextDistFrom = cur.distFromStart + neighbor[1];
                int nextId = neighbor[0];
                if (nextDistFrom < distTo[nextId]) {
                    distTo[nextId] = nextDistFrom;
                    q.offer(new State(nextId, nextDistFrom));
                }
            }
        }
        return distTo;
    }
}
