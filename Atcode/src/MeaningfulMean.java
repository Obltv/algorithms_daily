import java.util.*;

public class MeaningfulMean {
    public static void main(String[] args) {
        int res = 0;
        // 用于存储有序的前缀和
        List<Integer> list = new ArrayList<>();
        list.add(0); // 初始前缀和为0

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 数组长度
        int k = scan.nextInt(); // 给定的k值

        int[] a = new int[n + 1]; // 原数组，1下标起
        int[] b = new int[n + 1]; // 前缀和数组 b[i] = a[1] + ... + a[i] - k*i

        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            b[i] = b[i - 1] + a[i] - k; // 累加构造 b 数组
        }

        for (int i = 1; i <= n; i++) {
            res += count(b[i], list); // 统计有多少个 <= b[i] 的值
            insert(b[i], list);       // 把当前 b[i] 插入 list 中（保持有序）
        }

        System.out.println(res);
    }

    // 统计 list 中有多少个 <= value 的数（二分查找 + 等号版）
    public static int count(int value, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1; // 用于记录最后一个 ≤ value 的位置

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) <= value) {
                //ans = mid;     // 记录当前位置
                left = mid + 1; // 继续往右找
            } else {
                right = mid - 1;
            }
        }
        return left;// 有效个数 = 最后一个符合条件的位置 + 1
    }

    // 插入 value 到 list 的合适位置中（保持有序）
    public static void insert(int value, List<Integer> list) {
        int left = count(value, list);
        list.add(left, value); // left 是第一个 > value 的位置，插入到这里可以保持升序
    }
}
