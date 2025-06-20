import java.util.Scanner;

public class ps2121E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int res = 0;
            String s1 = sc.next();
            String s2 = sc.next();
            int n = s1.length();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    res += 2;
                } else if (((int) (s1.charAt(i) - '0') + 1) % 10 == ((int) s2.charAt(i) - '0')) {
                    res++;
                    i++;
                    while (i < n && s1.charAt(i) == '9' && s2.charAt(i) == '0') {
                        res++;
                        i++;
                    }
                    break;
                } else {
                    break;
                }
            }
            System.out.println(res);

        }
    }
}
