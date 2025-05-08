import java.util.*;

public class lc1514 {
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//        List<double[]>[] graph = new LinkedList[n];
//        for (int i = 0; i < n; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        for (int i = 0; i < edges.length; i++) {
//            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
//        }
//
//        double[][] distTo = dijkstra(start_node, end_node, graph);
//        return distTo[start_node][end_node];
//    }
//
//    class State {
//        int to;
//        double distFromStart;
//
//        public State(int to, double distFromStart) {
//            this.to = to;
//            this.distFromStart = distFromStart;
//        }
//    }
//
//    double[][] dijkstra(int start_node, int end_node, List<double[]>[] graph) {
//        double[][] distTo = new double[graph.length][graph.length];
//        Queue<State> q = new PriorityQueue<>((m, n) -> (int) (m.distFromStart - n.distFromStart));
//        q.offer(new State(start_node, 0));
//        while (!q.isEmpty()) {
//            State cur = q.poll();
//            int cur_to = cur.to;
//            double cur_dist = cur.distFromStart;
//            if (cur_dist > distTo[start_node][cur_to]) {
//                continue;
//            }
//            for (double[] edge : graph[cur_to]) {
//                double newTo = edge[0];
//                double newDist = edge[1] + distTo[start_node][cur_to];
//                if (newDist < distTo[start_node][(int) newTo]) {
//                    distTo[start_node][(int) newTo] = newDist;
//                    q.offer(new State((int) newTo, newDist));
//                }
//            }
//        }
//        return distTo;
//    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        class State {
            int node;
            double prob;

            public State(int node, double prob) {
                this.node = node;
                this.prob = prob;
            }
        }

        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double dist = succProb[i];
            graph[a].add(new double[]{b, dist});
            graph[b].add(new double[]{a, dist});
        }

        double[] distTo = new double[n];
        distTo[start_node] = 1.0;

        Queue<State> q = new PriorityQueue<>((u, v) -> Double.compare(v.prob, u.prob));
        q.offer(new State(start_node, 1.0));
        while (!q.isEmpty()) {
            State curr = q.poll();
            int curr_node = curr.node;
            double curr_pron = curr.prob;
            if (curr_node == end_node) {
                return curr_pron;
            }
            if (distTo[curr_node] > curr_pron) {
                continue;
            }
            for (double[] d : graph[curr_node]) {
                int nextNode = (int) d[0];
                double nextProb = d[1] * curr_pron;
                if (distTo[nextNode] < nextProb) {
                    distTo[nextNode] = nextProb;
                    q.offer(new State(nextNode, nextProb));
                }
            }
        }
        return 0.0;
    }
}
