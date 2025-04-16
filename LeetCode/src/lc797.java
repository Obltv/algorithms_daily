import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
方法思路
这道题目要求我们找到从节点0到节点n-1的所有可能路径，给定的图是一个有向无环图（DAG）。我们可以使用深度优先搜索（DFS）来遍历所有可能的路径。

DFS解法
递归遍历：从起始节点0开始，递归地访问每个可达的相邻节点

记录路径：使用一个链表来记录当前路径

到达终点处理：当到达目标节点n-1时，将当前路径添加到结果列表中

回溯：在递归返回时，需要移除当前节点以进行回溯，确保路径的正确性
 */
public class lc797 {
    // 存储所有最终结果的列表
    List<List<Integer>> res = new ArrayList<>();
    // 用于记录当前路径的链表（使用LinkedList便于尾部操作）
    LinkedList<Integer> path = new LinkedList<>();

    // 主方法：输入图的邻接表表示，返回所有从0到n-1的路径
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 从节点0开始深度优先搜索
        dfs(graph, 0);
        return res;
    }

    // 深度优先搜索方法
    void dfs(int[][] graph, int src) {
        // 将当前节点加入路径
        path.add(src);
        // 获取图中节点总数
        int n = graph.length;

        // 如果当前节点是终点（n-1）
        if (src == n - 1) {
            // 将当前路径的拷贝加入结果列表（需要新建ArrayList防止后续修改影响结果）
            res.add(new ArrayList<>(path));
            // 回溯：移除当前节点
            path.removeLast();
            return;
        }

        // 遍历当前节点的所有邻接节点
        for (int v : graph[src]) {
            // 递归搜索下一个节点
            dfs(graph, v);
        }

        // 回溯：移除当前节点（所有邻接节点都已处理完毕）
        path.removeLast();
    }
}