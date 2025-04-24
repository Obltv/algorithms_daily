import java.util.Arrays;
import java.util.Stack;

public class lc853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (int[] a, int[] b) -> {
            return Integer.compare(a[0], b[0]);
        });

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= time[i]) {
                stack.pop();
            }
            stack.push(time[i]);
        }
        return stack.size();
    }
}
