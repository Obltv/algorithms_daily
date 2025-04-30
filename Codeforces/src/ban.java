import java.util.ArrayList;
import java.util.List;

// 外部类，可根据需要放入项目中
public class ban {

    /**
     * 线性筛法（欧拉筛）实现，支持：
     * 1. 获取所有质数列表
     * 2. 判断某个数是否为质数
     * 3. 获取某个数的最小质因子（Smallest Prime Factor, SPF）
     */
    public class LinearSieve {
        private final boolean[] isPrime; // isPrime[i] = true 表示 i 是质数
        private final int[] spf;        // spf[i] 存储 i 的最小质因子
        private final List<Integer> primes; // 存储所有质数

        /**
         * 构造方法，初始化线性筛，计算 [0, n] 范围内的质数和最小质因子
         *
         * @param n 筛选范围的上界（n >= 2）
         */
        public LinearSieve(int n) {
            if (n < 2) {
                throw new IllegalArgumentException("n 必须 >= 2");
            }
            this.isPrime = new boolean[n + 1];
            this.spf = new int[n + 1];
            this.primes = new ArrayList<>();

            // 初始化，默认所有数都是质数
            for (int i = 2; i <= n; i++) {
                isPrime[i] = true;
            }

            // 线性筛核心逻辑
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                    spf[i] = i; // 质数的最小质因子是它本身
                }
                // 用当前数 i 和已找到的质数 primes[j] 筛去合数 i * primes[j]
                for (int j = 0; j < primes.size(); j++) {
                    int next = i * primes.get(j);
                    if (next > n) break; // 超过范围，跳出循环
                    isPrime[next] = false;
                    spf[next] = primes.get(j); // 记录最小质因子
                    if (i % primes.get(j) == 0) break; // 关键优化：保证只被最小质因子筛一次
                }
            }
        }

        /**
         * 获取所有质数列表
         *
         * @return 质数列表（升序）
         */
        public List<Integer> getPrimes() {
            return primes;
        }

        /**
         * 判断某个数是否为质数
         *
         * @param x 待判断的数
         * @return 如果 x 是质数且在筛选范围内，返回 true；否则返回 false
         */
        public boolean isPrime(int x) {
            return x >= 0 && x < isPrime.length && isPrime[x];
        }

        /**
         * 获取某个数的最小质因子（Smallest Prime Factor, SPF）
         *
         * @param x 待查询的数（必须在初始化范围内）
         * @return x 的最小质因子
         * @throws IllegalArgumentException 如果 x 超出范围或 x < 2
         */
        public int getSpf(int x) {
            if (x < 2 || x >= spf.length) {
                throw new IllegalArgumentException("x 必须在 [2, " + (spf.length - 1) + "] 范围内");
            }
            return spf[x];
        }
    }


}
