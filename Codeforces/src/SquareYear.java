import java.util.Scanner;

public class SquareYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            boolean flag = true;
            String s = scan.next();
            int m = Integer.parseInt(s);
            if(m==0){
                System.out.println(0+" "+0);
                flag = false;
            }
            for (int i = 1; i <= 100; i++) {
                if (i * i == m) {
                    int b = i - 1;
                    System.out.println(1 + " " + b);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            }
        }
    }
}
