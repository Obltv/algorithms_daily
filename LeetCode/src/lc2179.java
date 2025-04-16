import java.util.HashMap;

public class lc2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        //用hashmap记录第二个数组，然后用第一个数组当索引来查询
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int res = 0;//记录组数
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (map.get(nums1[i]) > map.get(nums1[j])) {
                    continue;
                }
                for (int k = j + 1; k < nums1.length; k++) {
                    if (!(map.get(nums1[j]) > map.get(nums1[k]))) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
/*
 *然而这种方法显然不行，时间复杂度太高
 * 如果是在都有序的请况下，时间复杂度会达到O（n^3)
 */