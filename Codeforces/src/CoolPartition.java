import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CoolPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int res = 1;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Set<Integer> set = new HashSet<>(n);
            set.add(arr[0]);
            int right = 1;
            int left = 1;
            while (left < n) {
                if (set.contains(arr[left])) {
                    set.remove(arr[left]);
                }
                if (set.size() == 0) {
                    res++;
                    for (int i = right; i <= left; i++) {
                        set.add(arr[i]);
                    }
                    right = left + 1;
                }
                left++;
            }

            System.out.println(res);
        }
    }
}
