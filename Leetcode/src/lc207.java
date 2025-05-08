import java.util.LinkedList;
import java.util.List;

public class lc207 {
    boolean[] visited;
    boolean[] isVisited;
    boolean flag = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        isVisited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < graph.length; i++) {
            traverse(i, graph);
        }
        return !flag;
    }

    void traverse(int v, List<Integer>[] graph) {
        if (flag) return;
        if (visited[v]) {
            flag = true;
            return;
        }
        if (isVisited[v]) {
            return;
        }
        visited[v] = true;
        isVisited[v] = true;
        for (int w : graph[v]) {
            traverse(w, graph);
        }
        visited[v] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
