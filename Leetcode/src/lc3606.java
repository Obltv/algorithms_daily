import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3606 {
//    class Solution {
//        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
//            int n = code.length;
//            List<String> ans = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                if (isC(code[i]) && isB(businessLine[i]) && isActive[i]) {
//                    ans.add(businessLine[i]);
//                }
//            }
//
//            return ans;
//        }
//
//        boolean isC(String s) {
//            if (s.length() == 0) return false;
//            for (int i = 0; i < s.length(); i++) {
//                if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '_') {
//
//                } else {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        boolean isB(String s) {
//            if (s != "electronics" || s != "grocery" || s != "pharmacy" || s != "restaurant") {
//                return false;
//            }
//            return true;
//        }
//    }

    class Solution {

        static class State {
            String code;
            String businessLine;

            State(String code, String businessLine) {
                this.code = code;
                this.businessLine = businessLine;
            }
        }

        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
            Map<String, Integer> categoryOrder = new HashMap<>();
            categoryOrder.put("electronics", 0);
            categoryOrder.put("grocery", 1);
            categoryOrder.put("pharmacy", 2);
            categoryOrder.put("restaurant", 3);

            List<State> ans = new ArrayList<>();

            for (int i = 0; i < code.length; i++) {
                if (code[i] == null || code[i].isEmpty() || !code[i].matches("[a-zA-Z0-9_]+")) {
                    continue;
                }
                if (!categoryOrder.containsKey(businessLine[i])) {
                    continue;
                }
                if (!isActive[i]) {
                    continue;
                }
                ans.add(new State(code[i], businessLine[i]));
            }

            ans.sort((a, b) -> {
                int k = Integer.compare(categoryOrder.get(a.businessLine), categoryOrder.get(b.businessLine));
                if (k == 0) {
                    return a.code.compareTo(b.code);
                }
                return k;
            });

            List<String> res = new ArrayList<>();
            for (State s : ans) {
                res.add(s.code);
            }

            return res;
        }


    }
}
