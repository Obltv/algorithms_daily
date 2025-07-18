import java.util.Scanner;

public class NC0716C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
        }
        long s = (long) n * (n - 1);
        System.out.println(s - m);
    }
}
