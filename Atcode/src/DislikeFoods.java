import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DislikeFoods {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] dislikes = new int[m];
        int[] b = new int[n];
        int count = 0;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int p = scan.nextInt();
            dislikes[i] = p;
            while (p-- > 0) {
                int a = scan.nextInt();
                list.get(a).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
            for (int num : list.get(b[i])) {
                dislikes[num]--;
                if (dislikes[num] == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
