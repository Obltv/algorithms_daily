import java.util.*;

public class LostSoul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            int[] b = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();
            }
            
            if (arr[n] == b[n]) {
                System.out.println(n);
                continue;
            }

            int index = 0;
            HashSet<Integer> set1 = new HashSet<>();
            for (int i = n - 1; i >= 1; i--) {
                if (arr[i] == b[i] || arr[i] == arr[i + 1] || b[i] == b[i + 1]) {
                    index = i;
                    break;
                }
                if (set1.contains(arr[i]) || set1.contains(b[i])) {
                    index = i;
                    break;
                }

                set1.add(arr[i + 1]);
                set1.add(b[i + 1]);
            }

            System.out.println(index);
        }

        sc.close();
    }
    
}
