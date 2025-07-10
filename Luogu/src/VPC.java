import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class VPC {

    static class State {
        long zi;
        long mu;

        State(long num, long den) {
            if (den < 0) {
                num = -num;
                den = -den;
            }
            long gcd = gcd(Math.abs(num), Math.abs(den));
            zi = num / gcd;
            mu = den / gcd;
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
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        for (int i = 0; i < n; i++) b[i] = sc.nextLong();

        int zeroCount = 0;
        Map<State, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                if (b[i] == 0) zeroCount++;
            } else {
                State s = new State(-b[i], a[i]);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        System.out.println(zeroCount + max);
    }

}
