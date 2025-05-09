import java.util.HashSet;

public class lc3343 {
    int res = 0;
    boolean[] visited;
    int ans1 = 0;
    int ans2 = 0;
    int index = 0;
    HashSet<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public int countBalancedPermutations(String num) {
        visited = new boolean[num.length()];
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }
        dfs(arr);
        return res;
    }

    void dfs(int[] arr) {
        if (ans1 == ans2 && ans1 != 0 && ans2 != 0 && index == arr.length) {
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                res++;
                return;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans1 += index % 2 == 0 ? arr[i] : 0;
                ans2 += index % 2 == 0 ? 0 : arr[i];
                index++;
                sb.append(arr[i]);
                dfs(arr);
                sb.deleteCharAt(sb.length() - 1);
                index--;
                ans2 -= index % 2 == 0 ? 0 : arr[i];
                ans1 -= index % 2 == 0 ? arr[i] : 0;
                visited[i] = false;
            }
        }
    }
}
