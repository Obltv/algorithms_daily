import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            char[] arr = new char[n];
            String s = scan.next();
            for (int i = 0; i < n; i++) {
                arr[i] = s.charAt(i);
            }
            if (n == 2) {
                String res = arr[0] == 'A' ? "Alice" : "Bob";
                System.out.println(res);
                continue;
            }

            if (arr[n - 1] == 'B') {
                if (arr[0] == 'B') {
                    System.out.println("Bob");
                } else {
                    boolean flag = false;
                    for (int i = 1; i < n - 1; i++) {
                        if (arr[i] == 'B') {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("Bob");
                    } else {
                        System.out.println("Alice");
                    }
                }
            } else {
                if (arr[0] == 'A') {
                    System.out.println("Alice");
                } else {
                    if (arr[n - 2] == 'A') {
                        System.out.println("Alice");
                    } else {
                        System.out.println("Bob");
                    }
                }
            }
        }
    }
}