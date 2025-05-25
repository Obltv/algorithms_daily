import java.util.*;

public class lc2131 {
    // public int longestPalindrome(String[] words) {
    //     HashMap<String, Integer> hm = new HashMap<>();
    //     for (String s : words) {
    //         hm.put(s, hm.getOrDefault(s, 0) + 1);
    //     }

    //     int res = 0;
    //     for (String s : words) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(s.charAt(1));
    //         sb.append(s.charAt(0));
    //         String str = sb.toString();
    //         if ((hm.containsKey(s) && hm.containsKey(str))&&(!s.equals(str))) {

    //             hm.put(str, hm.get(str) - 1);
    //             if (hm.get(str) == 0) {
    //                 hm.remove(str);
    //             }
    //             hm.put(s, hm.get(s) - 1);
    //                 if (hm.get(s) == 0) {
    //                     hm.remove(s);
    //                 }
    //             res += 4;
    //         }else if(s.equals(str)){
    //             if(hm.containsKey(s)&&hm.get(s)>=2){
    //                 int pair=hm.get(s)/2;
    //                 res+=4*pair;
    //                 hm.put(s,hm.get(s)-pair*2);
    //                 if(hm.get(s)==0) hm.remove(s);
    //             }

    //         }
    //     }

    //     for (String key : hm.keySet()) {
    //         if (key.charAt(0) == key.charAt(1)) {
    //             res += 2;
    //             break;
    //         }
    //     }

    //     return res;
    // }

    public int longestPalindrome(String[] words) {
        int res = 0;
        boolean flag = false;
        int[][] map = new int[26][26];
        for (String s : words) {
            int i = s.charAt(0) - 'a';
            int j = s.charAt(1) - 'a';
            map[i][j]++;
        }

        for (int i = 0; i < 26; i++) {
            int m = map[i][i];
            if (m % 2 == 1) {
                flag = true;
            }
            res += (m / 2) * 2;
            for (int j = i + 1; j < 26; j++) {
                res += Math.min(map[i][j], map[j][i]) * 2;
            }
        }
        return res * 2 + (flag ? 2 : 0);
    }
}
