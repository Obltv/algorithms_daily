import java.util.*;

public class lc3557 {
    public int maxSubstrings(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (hm.containsKey(c)) {
                if (i - hm.get(c) >= 3) {
                    res++;
                    hm.clear();
                } else {
                    continue;
                }
            } else {
                hm.put(c, i);
            }

        }
        return res;
    }
}
