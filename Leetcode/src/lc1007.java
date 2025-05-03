import java.util.HashMap;
import java.util.Map;

public class lc1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int num1 = -66;
        int num2 = -66;

        for (int i = 0; i < tops.length; i++) {
            map1.put(tops[i], map1.getOrDefault(tops[i], 0) + 1);
            if (max1 < map1.get(tops[i])) {
                max1 = map1.get(tops[i]);
                num1 = tops[i];
            }
        }
        for (int i = 0; i < bottoms.length; i++) {
            map2.put(bottoms[i], map2.getOrDefault(bottoms[i], 0) + 1);
            if (max2 < map2.get(bottoms[i])) {
                max2 = map2.get(bottoms[i]);
                num2 = bottoms[i];
            }
        }

        int count1 = 0;
        int count2 = 0;
        int res1 = 666666;
        int res2 = 666666;

        for (int i = tops.length - 1; i >= 0; i--) {
            if (tops[i] != num1) {
                if (bottoms[i] == num1) {
                    count1++;
                }
            }
        }


        if (count1 == tops.length - map1.getOrDefault(num1, 0)) {
            res1 = count1;
        }

        for (int i = bottoms.length - 1; i >= 0; i--) {
            if (bottoms[i] != num2) {
                if (tops[i] == num2) {
                    count2++;
                }
            }
        }

        if (count2 == tops.length - map2.getOrDefault(num2, 0)) {
            res2 = count2;
        }

        if (res1 == 666666 && res2 == 666666) {
            return -1;
        } else {
            return Math.min(res1, res2);
        }
    }
}
