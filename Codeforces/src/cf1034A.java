import java.util.Scanner;

public class cf1034A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n <= 3) {
                System.out.println("Alice");
                continue;
            }
            int m = n - 4;
            if (m % 4 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
