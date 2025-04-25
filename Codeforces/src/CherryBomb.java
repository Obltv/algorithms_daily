import java.util.HashSet;
import java.util.Scanner;

public class CherryBomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[n + 1];
            int c = -666;
            //不要用Integer.MAX_VALUE,因为后面+k,不判断就直接越界了
            int minNum = 1000000005;
            int maxNum = Integer.MIN_VALUE;
            HashSet<Integer> set = new HashSet<>();
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                a[i] = scan.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                b[i] = scan.nextInt();
                if (b[i] == -1) {
                    minNum = Math.min(minNum, a[i]);
                    maxNum = Math.max(maxNum, a[i]);
                } else {
                    c = a[i] + b[i];
                    set.add(c);
                    if (set.size() > 1) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                System.out.println(0);
                continue;
            }

            if (c != -666) {
                if (c <= minNum + k && c >= maxNum) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                int res = minNum + k - maxNum + 1;
                System.out.println(res);
            }
        }
    }
}
