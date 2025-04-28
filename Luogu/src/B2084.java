import java.util.Scanner;

public class B2084 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n / i);
                break;
            }
        }

        scan.close();
    }
}
