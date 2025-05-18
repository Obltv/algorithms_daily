import java.util.*;

public class lc0518Q3 {
//    int time = 0;
//    boolean flag = false;
//    int min = Integer.MAX_VALUE;
//    List<int[]>[] arr = new List[26];
//    int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    boolean[] isUsed = new boolean[26];
//    boolean[][] visited;
//
//    public int minMoves(String[] matrix) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new ArrayList<>();
//        }
//        char[][] board = new char[matrix.length][matrix[0].length()];
//        for (int i = 0; i < matrix.length; i++) {
//            String str = matrix[i];
//            for (int j = 0; j < str.length(); j++) {
//                board[i][j] = str.charAt(j);
//                if (board[i][j] >= 'A' && board[i][j] <= 'Z') {
//                    arr[board[i][j] - 'A'].add(new int[]{i, j});
//                }
//            }
//        }
//        if (board[0][0] == '#' || board[board.length - 1][board[0].length - 1] == '#') {
//            return -1;
//        }
//        visited = new boolean[board.length][board[0].length];
//        visited[0][0] = true;
//        dfs(board, 0, 0);
//        return flag ? time : -1;
//    }
//
//    void dfs(char[][] board, int a, int b) {
//        if (a == board.length - 1 && b == board[0].length - 1) {
//            flag = true;
//            if (min > time) {
//                min = time;
//            }
//            return;
//        }
//        if (board[a][b] >= 'A' && board[a][b] <= 'Z' && !isUsed[board[a][b] - 'A']) {
//            for (int i = 0; i < arr[board[a][b] - 'A'].size(); i++) {
//                int newA = arr[board[a][b] - 'A'].get(i)[0];
//                int newB = arr[board[a][b] - 'A'].get(i)[1];
//                isUsed[board[a][b] - 'A'] = true;
//                visited[a][b] = true;
//                dfs(board, newA, newB);
//                visited[a][b] = false;
//                isUsed[board[a][b] - 'A'] = false;
//            }
//        }
//        for (int i = 0; i < 4; i++) {
//            int newA = a + d[i][0];
//            int newB = b + d[i][1];
//            if (newA < 0 || newA >= board.length || newB < 0 || newB >= board[0].length || board[newA][newB] == '#') {
//                continue;
//            } else {
//                time++;
//                visited[a][b] = true;
//                dfs(board, newA, newB);
//                visited[a][b] = false;
//                time--;
//            }
//        }
//    }

//    int[][] distTo;
//    Queue<Node> q = new LinkedList<>();
//    boolean[] used = new boolean[26];
//    List<int[]>[] list = new List[26];
//
//
//    public int minMoves(String[] matrix) {
//        //初始化list
//        for (int i = 0; i < 26; i++) {
//            list[i] = new ArrayList<>();
//        }
//        //处理转化为二维组
//        int m = matrix.length;
//        int n = matrix[0].length();
//        char[][] group = new char[m][n];
//        for (int i = 0; i < matrix.length; i++) {
//            String s = matrix[i];
//            for (int j = 0; j < s.length(); j++) {
//                group[i][j] = s.charAt(j);
//                if (group[i][j] >= 'A' && group[i][j] <= 'Z') {
//                    list[group[i][j] - 'A'].add(new int[]{i, j});
//                }
//            }
//        }
//
//        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        distTo = new int[group.length][group[0].length];
//        q.offer(new Node(0, 0, 0));
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//            int x = node.x;
//            int y = node.y;
//            int step = node.step;

    /// /            //base case
    /// /            if (x == group.length - 1 && y == group[0].length - 1) {
    /// /                return step;
    /// /            }
//            //上下左右遍历
//            for (int i = 0; i < 4; i++) {
//                //传送
//                if (group[x][y] >= 'A' && group[x][y] <= 'Z' && used[group[x][y] - 'A'] == false) {
//                    used[group[x][y] - 'A'] = true;
//                    for (int j = 0; j < list[group[x][y] - 'A'].size(); j++) {
//                        int newX = list[group[x][y] - 'A'].get(j)[0];
//                        int newY = list[group[x][y] - 'A'].get(j)[1];
//                        if (distTo[newX][newY] != 0 && distTo[newX][newY] > step && (newX != x || newY != y)) {
//                            distTo[newX][newY] = step;
//                            q.offer(new Node(newX, newY, distTo[newX][newY]));
//                        }
//                    }
//                    used[group[x][y] - 'A'] = false;
//                }
//                int newX = x + d[i][0];
//                int newY = y + d[i][1];
//
//                if (newX < 0 || newX >= m || newY < 0 || newY >= n || group[newX][newY] == '#') {
//                    continue;
//                }
//
//                if (distTo[newX][newY] != 0 && distTo[newX][newY] > step + 1) {
//                    distTo[newX][newY] = step + 1;
//                    q.offer(new Node(newX, newY, distTo[newX][newY]));
//                }
//            }
//        }
//        return distTo[m - 1][n - 1] == 0 ? -1 : distTo[m - 1][n - 1];
//    }
//
//    class Node {
//        int x;
//        int y;
//        int step;
//
//        public Node(int x, int y, int step) {
//            this.x = x;
//            this.y = y;
//            this.step = step;
//        }
//    }

    List<int[]>[] list = new List[26];

    public int minMoves(String[] matrix) {
        //初始化list
        Arrays.fill(list, new ArrayList<>());
        //转为二维组
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = matrix[i];
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] >= 'A' && grid[i][j] <= 'Z') {
                    int a = grid[i][j] - 'A';
                    list[a].add(new int[]{i, j});
                }
            }
        }

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

        }
    }
}