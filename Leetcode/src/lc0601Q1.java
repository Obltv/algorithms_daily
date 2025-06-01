import java.util.Arrays;
import java.util.HashSet;

public class lc0601Q1 {
//    long res = 1;
//    boolean ans = false;
//    boolean[] visited;
//
//    public boolean checkEqualPartitions(int[] nums, long target) {
//        long sum = 1;
//        visited = new boolean[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            sum *= nums[i];
//        }
//        if (nums.length == 1) return false;
//        if (sum != target * target || sum == target) {
//            return false;
//        }
//        dfs(nums, target, 0, 0);
//        return ans;
//    }
//
//    void dfs(int[] nums, long target, int k, int count) {
//        if (res == target) {
//            if (count == nums.length) return;
//
//            long sum2 = 1;
//            for (int i = 0; i < nums.length; i++) {
//                if (!visited[i]) {
//                    sum2 *= nums[i];
//                }
//            }
//
//            if (sum2 == target) ans = true;
//        }
//        if (ans) return;
//        for (int i = k; i < nums.length; i++) {
//            visited[i] = true;
//            res *= nums[i];
//            dfs(nums, target, i + 1, count + 1);
//            res /= nums[i];
//            visited[i] = false;
//        }
//    }

    public class Solution {
        boolean ans = false;
        boolean[] visited;

        public boolean checkEqualPartitions(int[] nums, long target) {
            long sum = 1;
            visited = new boolean[nums.length];

            for (int num : nums) {
                sum *= num;
            }

            if (nums.length == 1) return false;
            if (sum != target * target || sum == target) return false;

            dfs(nums, target, 0, 1, 0);
            return ans;
        }

        void dfs(int[] nums, long target, int index, long res, int count) {
            if (ans) return;

            if (res == target) {
                if (count == nums.length) return;

                long sum2 = 1;
                for (int i = 0; i < nums.length; i++) {
                    if (!visited[i]) {
                        sum2 *= nums[i];
                    }
                }

                if (sum2 == target) {
                    ans = true;
                }
                return;
            }

            for (int i = index; i < nums.length; i++) {
                visited[i] = true;
                dfs(nums, target, i + 1, res * nums[i], count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        //6==0110
        int a = 6;
        //3==0011
        int b = 3;

        //& 按位与 对应位都为1时才为1
        //输出2==0010
        System.out.println(a & b);

        //| 按位或 只要其中一位是 1，结果就是 1
        //输出7==0111
        System.out.println(a | b);

        //^ 按位异或 不同为1，相同为0
        //输出5==0101
        System.out.println(a ^ b);

        //~ 按位取反，0变1，1变0
        //输出-7
        /*
        详细解释一下这个
        6 的二进制（原码）:  00000000 00000000 00000000 00000110
        ~6 :  11111111 11111111 11111111 11111001 负数
        取反码 00000000 00000000 00000000 00000110
        +1 00000000 00000000 00000000 00000111 结果为7
        加 - 号
         */
        System.out.println(~a);

        //<< 左移 所有位向左移动 n 位，右边补 0    6 << 1 = 12（1100）
        //不溢出的情况下  a << n 相当于 a * 2ⁿ
        System.out.println(a<<1);

        //>> 右移 所有位向右移动 n 位，保留符号位   6 >> 1 = 3（011）
        System.out.println(a>>1);

        //>>> 无符号右移 所有位右移 n 位，左边补 0   -1 >>> 1（补 0）

    }



}
