//import java.util.*;
//
//public class problemset4D {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int w = sc.nextInt();
//        int h = sc.nextInt();
//        int[][] arr = new int[n + 1][2];
//        arr[0][0] = w;
//        arr[0][1] = h;
//
//        for (int i = 1; i <= n; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//
//        Arrays.sort(arr, (int[] a, int[] b) -> {
//            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
//        });
//
//        int[] dp = new int[n + 1];
//        int[] f = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            f[i] = i;
//        }
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < n + 1; i++) {
//            if (arr[i][0] <= w || arr[i][1] <= h) {
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                if (arr[j][0] <= w || arr[j][1] <= h) {
//                    continue;
//                }
//
//                if (arr[i][1] > arr[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    f[i] = j;
//                }
//            }
//        }
//
//        int res = 0;
//        int index = -1;
//        for (int i = 0; i < n + 1; i++) {
//            res = Math.max(res, dp[i]);
//            index = i;
//        }
//
//        System.out.println(res);
//        List<Integer> list = new ArrayList<>();
//        list.add(index);
//        while (f[index] != index) {
//            list.add(f[index]);
//            index = f[index];
//        }
//
//        Collections.reverse(list);
//        for (int num : list) {
//            System.out.print(num + " ");
//        }
//    }
//}
import java.util.*;

public class problemset4D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 信封数量
        int w = sc.nextInt(); // 卡片宽
        int h = sc.nextInt(); // 卡片高

        int[][] arr = new int[n][3]; // arr[i][0] = w, arr[i][1] = h, arr[i][2] = 编号
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = i + 1; // 编号从1开始
        }

        // 排序：宽升序，高降序（防止宽一样时重复用）
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] dp = new int[n]; // dp[i] 表示以第i个信封结尾的最长链长度
        int[] prev = new int[n]; // prev[i] 用于回溯路径
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) prev[i] = i;

        int maxLen = 0;
        int lastIdx = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] <= w || arr[i][1] <= h) continue; // 卡片装不进
            for (int j = 0; j < i; j++) {
                if (arr[j][0] <= w || arr[j][1] <= h) continue;
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        // 如果没有合法链
        if (maxLen == 0) {
            System.out.println(0);
            return;
        }

        // 回溯输出路径
        List<Integer> res = new ArrayList<>();
        while (prev[lastIdx] != lastIdx) {
            res.add(arr[lastIdx][2]); // 存编号
            lastIdx = prev[lastIdx];
        }
        res.add(arr[lastIdx][2]); // 加上头节点

        Collections.reverse(res);
        System.out.println(res.size());
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
