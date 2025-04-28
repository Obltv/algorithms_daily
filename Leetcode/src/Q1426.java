import java.util.*;

public class Q1426 {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : responses) {
            Set<String> set = new HashSet<>();
            for (String s : list) {
                set.add(s);
            }
            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int maxIndex = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxIndex) {
                maxIndex = entry.getValue();
            }
        }

        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxIndex) {
                if (res.equals("")) {
                    res = entry.getKey();
                }
                String a = entry.getKey();
                char[] arr = a.toCharArray();
                char[] arr1 = res.toCharArray();
                String tmp = res;
                int len = Math.min(arr.length, arr1.length);
                boolean flag = true;
                for (int i = 0; i < len; i++) {
                    if (arr[i] < arr1[i]) {
                        res = a;
                        break;
                    } else if (arr[i] > arr1[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = res.length() > a.length() ? a : res;
                }
            }
        }
        return res;
    }

}
