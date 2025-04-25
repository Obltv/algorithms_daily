import java.util.Scanner;

public class DrTC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int p = 0, q = 0;
            int n = scan.nextInt();
            String s = scan.next();
            char[] arr = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    p++;
                } else {
                    q++;
                }
            }

            int res = (p - 1) * p + (p + 1) * q;
            System.out.println(res);
        }
    }
}
