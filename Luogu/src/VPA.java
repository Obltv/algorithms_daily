import java.util.*;

public class VPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int res = n - 1;
            for (int i = 2; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                    res--;
                }
            }
            System.out.println(res);
        }
    }
}
