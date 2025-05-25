import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.*;
import java.util.TreeSet;
import java.util.stream.Stream;


public class lc0524Q1 {

//    class LinearSieve {
//        private final boolean[] isPrime; // isPrime[i] = true 表示 i 是质数
//        private final int[] spf;        // spf[i] 存储 i 的最小质因子
//        private final List<Integer> primes; // 存储所有质数
//
//        /**
//         * 构造方法，初始化线性筛，计算 [0, n] 范围内的质数和最小质因子
//         *
//         * @param n 筛选范围的上界（n >= 2）
//         */
//        public LinearSieve(int n) {
//            if (n < 2) {
//                throw new IllegalArgumentException("n 必须 >= 2");
//            }
//            this.isPrime = new boolean[n + 1];
//            this.spf = new int[n + 1];
//            this.primes = new ArrayList<>();
//
//            // 初始化，默认所有数都是质数
//            for (int i = 2; i <= n; i++) {
//                isPrime[i] = true;
//            }
//
//            // 线性筛核心逻辑
//            for (int i = 2; i <= n; i++) {
//                if (isPrime[i]) {
//                    primes.add(i);
//                    spf[i] = i; // 质数的最小质因子是它本身
//                }
//                // 用当前数 i 和已找到的质数 primes[j] 筛去合数 i * primes[j]
//                for (int j = 0; j < primes.size(); j++) {
//                    int next = i * primes.get(j);
//                    if (next > n) break; // 超过范围，跳出循环
//                    isPrime[next] = false;
//                    spf[next] = primes.get(j); // 记录最小质因子
//                    if (i % primes.get(j) == 0) break; // 关键优化：保证只被最小质因子筛一次
//                }
//            }
//        }
//
//        /**
//         * 获取所有质数列表
//         *
//         * @return 质数列表（升序）
//         */
//        public List<Integer> getPrimes() {
//            return primes;
//        }
//
//        /**
//         * 判断某个数是否为质数
//         *
//         * @param x 待判断的数
//         * @return 如果 x 是质数且在筛选范围内，返回 true；否则返回 false
//         */
//        public boolean isPrime(int x) {
//            return x >= 0 && x < isPrime.length && isPrime[x];
//        }
//
//        /**
//         * 获取某个数的最小质因子（Smallest Prime Factor, SPF）
//         *
//         * @param x 待查询的数（必须在初始化范围内）
//         * @return x 的最小质因子
//         * @throws IllegalArgumentException 如果 x 超出范围或 x < 2
//         */
//        public int getSpf(int x) {
//            if (x < 2 || x >= spf.length) {
//                throw new IllegalArgumentException("x 必须在 [2, " + (spf.length - 1) + "] 范围内");
//            }
//            return spf[x];
//        }
//    }
//
//
//    int[] arr = new int[100005];
//    LinearSieve ls = new LinearSieve(2000000000);
//    int index = 0;
//
//    public long sumOfLargestPrimes(String s) {
//
//        for (int i = 1; i <= s.length(); i++) {
//            check(i, s);
//        }
//        Arrays.sort(arr);
//        int count = 0;
//        int res = 0;
//        for (int num : arr) {
//            res += num;
//            count++;
//            if (count == 3) {
//                break;
//            }
//        }
//        return res;
//    }
//
//    void check(int i, String s) {
//        for (int j = i; j < s.length(); j++) {
//            String s1 = s.substring(j - i + 1, j);
//            int a = Integer.parseInt(s1);
//            if (ls.isPrime(a)) {
//                arr[index++] = a;
//            }
//        }
//    }

    // public long sumOfLargestPrimes(String s) {

    //     HashSet<Long> list = new HashSet<>();
    //     for (int i = 1; i <= s.length(); i++) {
    //         for (int j = 0; j + i <= s.length(); j++) {
    //             String str = s.substring(j, j + i);
    //             long a = Long.parseLong(str);
    //             if (isP(a)) {
    //                 list.add(a);
    //             }
    //         }
    //     }

    //     Long[] arr = list.toArray(new Long[0]);
    //     Arrays.sort(arr);

    //     long res = 0;
    //     for (int i = arr.length - 1; i >= Math.max(0, arr.length - 3); i--) {
    //         res += arr[i];
    //     }

    //     return res;

    // }

    // boolean isP(long num) {
    //     if (num < 2) return false;
    //     if (num == 2) return true;
    //     if (num % 2 == 0) return false;
    //     for (int i = 3; i * i <= num; i += 2) {
    //         if (num % i == 0) return false;
    //     }
    //     return true;
    // }

    public long sumOfLargestPrimes(String s) {
        int n = s.length();

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            long l = 0;
            for (int j = i; j < n; j++) {
                l = l * 10 + (s.charAt(j) - '0');
                if (isPrime(l)) {
                    set.add(l);
                }
            }
        }

        return set.descendingSet()
                .stream()
                .limit(3)
                .mapToLong(Long::longValue)
                .sum();
    }

    boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if(num % 2 == 0) return false;
        for (long i = 3; i * i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
