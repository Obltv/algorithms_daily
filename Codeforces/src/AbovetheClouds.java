import java.util.Scanner;

public class AbovetheClouds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if (n < 3) {
                System.out.println("No");
                continue;
            }
            char[] arr = s.toCharArray();
            int[] b = new int[26];
            for (char c : arr) {
                b[c - 'a']++;
            }

            boolean res = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (b[arr[i] - 'a'] > 1) {
                    res = true;
                    break;
                }
            }

            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
