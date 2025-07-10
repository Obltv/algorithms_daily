import java.util.Scanner;

public class NC16438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int res = 0;
        for (int i = n1; i <= n2; i++) {
            String s = String.valueOf(i);
            boolean flag = true;
            for (int j = 0; j < s.length() / 2; j++) {
                if (s.charAt(j) == s.charAt(s.length() - j - 1)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }

        System.out.println(res);
    }
}
