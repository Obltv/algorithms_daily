import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P12157 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > n + m) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                int s = a[i] + b[j];
                if (isP(s) && s <= m + n) {
                    set.add(s);
                }
            }
        }

        System.out.println(set.size());
    }
    public static boolean isP(int s) {
        if (s == 2) {
            return true;
        }
        for (int i = 3; i < Math.sqrt(s); i += 2) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }
}
