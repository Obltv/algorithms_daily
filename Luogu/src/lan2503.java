import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lan2503 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        int t = sc.nextInt();
//        int max = Integer.MIN_VALUE;
//        int[] arr = new int[t];
//        for (int i = 0; i < t; i++) {
//            arr[i] = sc.nextInt();
//            max = Math.max(max, arr[i]);
//        }
//
//        Map<Integer, int[]> map = new HashMap<>();
//        map.put(1, new int[]{11, 1});
//        int p = 12;
//        int q = 2;
//        while (p <= max) {
//            for (int i = p + k; i <= max; i++) {
//                if (isgcd(p, i)) {
//                    map.put(p, new int[]{i, q});
//                    p = i + 1;
//                    q++;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < t; i++) {
//            int l = arr[i] + 1;
//            while (l-- > 0) {
//                if (map.containsKey(l)) {
//                    System.out.println(map.get(l)[1]);
//                    break;
//                }
//            }
//        }
//
//    }

    static final int N = 1000010; // 最大可能的 n
    static int[] id = new int[N]; // id[i] 表示数字 i 属于第几个美丽区间

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 最小间隔
        int t = sc.nextInt(); // 测试用例组数
        int[] res = new int[t];
        int maxN = 0;

        // 读入所有 n，记录最大值，便于优化
        for (int i = 0; i < t; i++) {
            res[i] = sc.nextInt();
            maxN = Math.max(maxN, res[i]);
        }

        // 预处理：构造所有美丽区间，记录每个数属于哪个区间
        int L = 1, R = 1, idIndex = 1;
        while (L <= maxN) {
            // 尽可能短满足 gcd(L, R) == 1 且 R - L >= k
            R = L + k;
            while (gcd(L, R) != 1) R++;
            for (int i = L; i <= R && i < N; i++) {
                id[i] = idIndex;
            }
            // 更新到下一个区间
            L = R + 1;
            idIndex++;
        }

        // 输出答案
        for (int n : res) {
            System.out.println(id[n]);
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static boolean isgcd(int a, int b) {
        return gcd(a, b) == 1;
    }

}
