import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class VPC2 {

    static class State {
        long zi;
        long mu;

        public State(long zi, long mu) {
            if (mu < 0) {
                mu = -mu;
                zi = -zi;
            }

            long g = gcd(Math.abs(zi), Math.abs(mu));
            this.zi = zi / g;
            this.mu = mu / g;

        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return zi == state.zi && mu == state.mu;
        }

        @Override
        public int hashCode() {
            return Objects.hash(zi, mu);
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        int res1 = 0;
        Map<State, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == 0 && b[i] == 0) {
                res1++;
            } else {
                State s = new State(-b[i], a[i]);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;

        for(int count : map.values()){
            max = Math.max(count, max);
        }

        long ans = res1 + max;
        System.out.println(ans);
    }
}
