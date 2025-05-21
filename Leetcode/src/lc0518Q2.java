import java.util.Arrays;

public class lc0518Q2 {
//    public int minSwaps(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            arr[i] = wei(nums[i]);
//        }
//
//        return -1;
//    }
//
//    public int wei(int i) {
//        int sum = 0;
//        while (i > 0) {
//            sum += i % 10;
//            i = i / 10;
//        }
//        return sum;
//    }

    public int minSwaps(int[] nums) {
        class UniFind {
            int[] f;
            int count;

            public UniFind(int n) {
                f = new int[n];
                for (int i = 0; i < n; i++) {
                    f[i] = i;
                }
                count = n;
            }

            public int find(int x) {
                if (f[x] != x) {
                    f[x] = find(f[x]);
                }
                return f[x];
            }

            public int count() {
                return count;
            }

            public void merge(int a, int b) {
                int m = find(a);
                int n = find(b);
                if (m == n) return;
                f[m] = n;
                count--;
            }
        }

        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int s = 0;
            while (nums[i] > 0) {
                s += nums[i] % 10;
                nums[i] /= 10;
            }
            arr[i][0] = s;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);
        UniFind uf = new UniFind(n);
        for (int i = 0; i < n; i++) {
            uf.merge(arr[i][2], i);
        }
        return n - uf.count();
    }
}
