import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P1440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a=new int[n+2];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(0);
        for (int i = 1; i < n; i++) {
            while (!q.isEmpty() && a[q.getLast()] >= a[i]) {
                q.removeLast();
            }
            q.addLast(i);
            while (!q.isEmpty() && i - q.getFirst() >= m) {
                q.removeFirst();
            }
            System.out.println(a[q.getFirst()]);
        }
    }
}
