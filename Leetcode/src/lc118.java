import java.util.ArrayList;
import java.util.List;

public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            int[] arr = new int[i];
            arr[0] = 1;
            arr[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                arr[j] = res.get(i - 1).get(j) + res.get(i).get(j);
            }
            List<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            res.add(list);
        }
        return res;
    }
}
