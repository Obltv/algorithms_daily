public class lc1432 {
    class Solution {
        public int maxDiff(int num) {
            String s = Integer.toString(num);
            char[] arr1 = s.toCharArray();
            char[] arr2 = s.toCharArray();

            int index1 = 0;
            int index2 = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '9') {
                    index1 = i;
                    break;
                }
            }

            if (s.charAt(0) == '1') {
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                        index2 = i;
                        break;
                    }
                }
            } else {
                index2 = 0;
            }

            char a1 = s.charAt(index1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == a1) {
                    arr1[i] = '9';
                }
            }

            char a2 = s.charAt(index2);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == a2) {
                    if (index2 == 0) {
                        arr2[i] = '1';
                    } else {
                        arr2[i] = '0';
                    }
                }
            }

            String str1 = new String(arr1);
            String str2 = new String(arr2);

            int res1 = Integer.parseInt(str1);
            int res2 = Integer.parseInt(str2);

            int res = res1 - res2;
            return res;
        }
    }
}
