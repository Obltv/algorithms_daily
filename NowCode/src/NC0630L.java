import java.util.Scanner;

public class NC0630L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m == n) {
            System.out.println(1);
        } else {
            System.out.println(n - m);
        }
    }
}
