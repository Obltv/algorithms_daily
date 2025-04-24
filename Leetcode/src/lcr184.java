import java.util.ArrayDeque;
import java.util.Deque;

public class lcr184 {
    class Checkout {

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        public Checkout() {

        }

        public int get_max() {
            return q2.isEmpty() ? -1 : q2.getFirst();
        }

        public void add(int value) {
            q1.addLast(value);
            while (!q2.isEmpty() && q2.peekLast() <= value) {
                q2.removeLast();
            }
            q2.addLast(value);
        }

        public int remove() {
            int a = q1.isEmpty() ? -1 : q1.removeFirst();
            if (!q2.isEmpty() && q2.getFirst() == a) {
                q2.removeFirst();
            }
            return a;
        }
    }
}
