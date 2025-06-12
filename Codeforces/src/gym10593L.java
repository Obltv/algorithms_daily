import java.util.Scanner;

public class gym10593L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "OBAFGKM";
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A'] = s.length() - i;
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            char a = s1.charAt(0);
            char b = s2.charAt(0);
            if (arr[a - 'A'] > arr[b - 'A']) {
                System.out.println("hotter");
            } else if (arr[a - 'A'] < arr[b - 'A']) {
                System.out.println("cooler");
            } else {
                int m = s1.charAt(1) - '0';
                int n = s2.charAt(1) - '0';
                if (m == n) {
                    System.out.println("same");
                } else if (m < n) {
                    System.out.println("hotter");
                } else {
                    System.out.println("cooler");
                }
            }
        }
    }
}
