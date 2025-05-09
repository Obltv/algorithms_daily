import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lc210 {
    List<Integer> postorder = new ArrayList();
    boolean[] onPath;
    boolean[] visited;
    boolean flag = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        List<Integer>[] graph = toGraph(numCourses, prerequisites);
        for (int i = 0; i < graph.length; i++) {
            traverse(i, graph);
        }
        if (flag) {
            return new int[]{};
        }
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    void traverse(int i, List<Integer>[] graph) {
        if (onPath[i]) {
            flag = true;
        }
        if (visited[i] || flag) {
            return;
        }
        onPath[i] = true;
        visited[i] = true;
        for (int s : graph[i]) {
            traverse(s, graph);
        }
        postorder.add(i);
        onPath[i] = false;
    }

    List<Integer>[] toGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        // for (int i = 0; i < numCourses; i++) {
        //     int a = prerequisites[i][1];
        //     int b = prerequisites[i][0];
        //     graph[a].add(b);
        // }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}