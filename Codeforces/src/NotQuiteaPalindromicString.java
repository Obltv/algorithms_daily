import java.util.Scanner;

public class NotQuiteaPalindromicString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            String s = scan.next();
            int[] arr = new int[2];
            for (int i = 0; i < n; i++) {
                int m = s.charAt(i) - '0';
                arr[m]++;
            }

            if (arr[0] < n/2 - k || arr[1] < n/2 - k) {
                System.out.println("NO");
            } else {
                arr[0] -= n/2 - k;
                arr[1] -= n/2 - k;
                if (arr[0] % 2 == 1 || arr[1] % 2 == 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
