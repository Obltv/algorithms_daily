import java.util.Scanner;

public class StChroma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int x = scan.nextInt();

            if (x >= n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(i + " ");
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (i == x) {
                        continue;
                    } else {
                        System.out.print(i + " ");
                    }
                }
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
