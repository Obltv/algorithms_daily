import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class RestaurantQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new ArrayDeque<>();
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            if (a == 1) {
                int b = sc.nextInt();
                q.offer(b);
            } else {
                System.out.println(q.poll());
            }
        }
    }
}
