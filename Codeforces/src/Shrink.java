import java.util.Scanner;

public class Shrink {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.print(1 + " ");
            for (int i = 1; i < n - 1; i++) {
                int m = i + 2;
                System.out.print(m + " ");
            }
            System.out.print(2 + " ");
            System.out.println();
        }
    }
}
