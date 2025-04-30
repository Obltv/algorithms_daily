import java.util.Scanner;

public class ThreeDecks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            if (a + c < 2 * b) {
                System.out.println("NO");
            } else {
                int sum = a + b + c;
                if (sum % 3 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }
}
