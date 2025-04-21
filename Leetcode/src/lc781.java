import java.util.HashMap;
import java.util.Map;

public class lc781 {
    public int numRabbits(int[] answers) {
        int minCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            if (a == 0) {
                minCount++;
            } else {
                map.put(a, map.getOrDefault(a, 0) + 1);
                if (map.get(a) == a + 1) {
                    minCount += a + 1;
                    map.remove(a);
                }
            }
        }

        for (int key : map.keySet()) {
            minCount += key + 1;
        }
        return minCount;
    }
}
