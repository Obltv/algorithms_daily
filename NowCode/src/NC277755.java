import java.util.Scanner;

public class NC277755 {
//失败解法，过45%
//    static long k = (long) 1e18;
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long n = scan.nextLong();
//        int count = 0;
//        long k1 = k + 1, k2 = k + 1;
//        for (int i = 2; i <= n; i++) {
//            if (isK(n, i) && count == 0) {
//                k1 = i;
//                count++;
//            } else if (isK(n, i) && count == 1) {
//                k2 = i;
//                count++;
//            }
//            if (count == 2) {
//                break;
//            }
//        }
//        if (count == 2) {
//            System.out.println("YES");
//            System.out.print(k1+" ");
//            System.out.print(k2);
//        } else {
//            System.out.println("NO");
//        }
//    }
//
//
//    public static boolean isK(long n, int k) {
//        boolean flag = true;
//        while (n > 0) {
//            long a = n % k;
//            if (a > 1) {
//                flag = false;
//                break;
//            }
//            n /= k;
//        }
//        return flag;
//    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long n=scan.nextLong();

        if(n==1){
            System.out.println("YES");
            System.out.print(2+" ");
            System.out.println(8);
        }else if(n==2){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.print(2+" ");
            System.out.println(n);
        }
    }
}
