import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 外部类，可根据需要放入项目中
public class ban {


    //质数筛
    class LinearSieve {
        /**
         * 线性筛法（欧拉筛）实现，支持：
         * 1. 获取所有质数列表
         * 2. 判断某个数是否为质数
         * 3. 获取某个数的最小质因子（Smallest Prime Factor, SPF）
         */


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

    //并查集
    class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = find(parent[p]);
                p = parent[p];
            }
            return parent[p];
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }

    }

    //最大公约数
    class GCD{
        // 使用辗转相除法（欧几里得算法）
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public static boolean isCoprime(int a, int b) {
            return gcd(a, b) == 1;
        }
    }

    //求平方自由部分squareFree(int x)
    class NumberTheoryUtils {

        /**
         * 返回一个整数的“平方自由形式”，即剔除所有出现偶数次的质因子。
         * 举例：
         * - 12 = 2^2 * 3 => squareFree(12) = 3
         * - 18 = 2 * 3^2 => squareFree(18) = 2
         * - 30 = 2 * 3 * 5 => squareFree(30) = 30
         *
         * 该形式常用于分类、哈希或找等价类等场景。
         */
        public static int squareFree(int x) {
            int res = 1;
            for (int i = 2; i * i <= x; i++) {
                int cnt = 0;
                while (x % i == 0) {
                    x /= i;
                    cnt++;
                }
                if ((cnt & 1) == 1) {
                    res *= i;
                }
            }
            if (x > 1) {
                res *= x;
            }
            return res;
        }
    }

    //最长递增子序列
    class LIS {

        /**
         * 方法一：动态规划 O(n^2)
         * 返回最长递增子序列的长度
         */
        public static int lengthOfLIS_DP(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n]; // dp[i] 表示以 nums[i] 结尾的 LIS 长度
            Arrays.fill(dp, 1); // 初始每个位置至少长度为1

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            for (int len : dp) {
                res = Math.max(res, len);
            }
            return res;
        }

        /**
         * 方法二：贪心 + 二分 O(nlogn)
         * 返回最长递增子序列的长度
         */
        public static int lengthOfLIS_BinarySearch(int[] nums) {
            List<Integer> pileTops = new ArrayList<>(); // 模拟每一堆的顶部数字
            for (int num : nums) {
                int idx = lowerBound(pileTops, num); // 找到第一个 ≥ num 的位置
                if (idx == pileTops.size()) {
                    pileTops.add(num); // 新建一堆
                } else {
                    pileTops.set(idx, num); // 替换堆顶
                }
            }
            return pileTops.size();
        }

        /**
         * 二分查找：返回第一个 ≥ target 的位置（lower_bound）
         */
        private static int lowerBound(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

    }

    //快速幂
    class FastPower {
        private final long MOD;

        public FastPower(long mod) {
            this.MOD = mod;
        }

        // 快速幂方法：计算 b^e % MOD
        public long pow(long base, long exp) {
            long result = 1;
            base %= MOD;  // 避免 base 太大

            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = result * base % MOD;
                }
                base = base * base % MOD;
                exp >>= 1;
            }

            return result;
        }
    }

    //模运算
    class Combinatorics {
        private static final int MOD = 1_000_000_007;
        private static final int MX = 100_001; // 按需修改，例如1e5、2e5

        private static final long[] F = new long[MX];       // F[i] = i!
        private static final long[] INV_F = new long[MX];   // INV_F[i] = i!^-1 mod MOD

        static {
            // 初始化阶乘数组
            F[0] = 1;
            for (int i = 1; i < MX; i++) {
                F[i] = F[i - 1] * i % MOD;
            }

            // 初始化阶乘逆元数组，先算出最大值的逆元
            INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
            for (int i = MX - 1; i > 0; i--) {
                INV_F[i - 1] = INV_F[i] * i % MOD;
            }
        }

        // 快速幂计算 x^n % MOD
        private static long pow(long x, int n) {
            long res = 1;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = res * x % MOD;
                }
                x = x * x % MOD;
                n >>= 1;
            }
            return res;
        }

        /**
         * 计算组合数 C(n, m) = n! / (m! * (n-m)!) % MOD
         * 如果 m < 0 或 m > n，则返回 0
         */
        public static long comb(int n, int m) {
            if (m < 0 || m > n) return 0;
            return F[n] * INV_F[m] % MOD * INV_F[n - m] % MOD;
        }

        /**
         * 可选扩展功能：阶乘查询
         */
        public static long fact(int n) {
            return F[n];
        }

        public static long invFact(int n) {
            return INV_F[n];
        }
    }




}
