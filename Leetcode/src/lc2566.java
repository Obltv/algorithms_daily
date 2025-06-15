public class lc2566 {
    class Solution {
        public int minMaxDifference(int num) {
            String s = String.valueOf(num);

            // 构造最小值：将第一个字符替换为 '0'
            char[] arr = s.toCharArray();
            char a = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == a) {
                    arr[i] = '0';
                }
            }

            // 构造最大值：将第一个字符替换为 '9'
            char[] b = s.toCharArray();
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (b[i] != '9') {
                    index = i;
                    break;
                }
            }

            char m = b[index];
            for (int i = 0; i < arr.length; i++) {
                if (b[i] == m) {
                    b[i] = '9';
                }
            }

            // 注意这里：正确构造字符串
            String str = new String(arr);
            String str1 = new String(b);

            int res1 = Integer.parseInt(str);
            int res2 = Integer.parseInt(str1);

            return res2 - res1;
        }

    }


}