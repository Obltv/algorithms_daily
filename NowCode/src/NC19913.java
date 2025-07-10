import java.util.Scanner;

public class NC19913 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int b = sc.nextInt();
//
//        int index = -1;
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            if (arr[i] == b) {
//                index = i;
//            }
//        }
//
//        int res = 0;
//        int right = index;
//        int left = index;
//        int num1 = 0;
//        int num2 = 0;
//        while (right < arr.length && left >= 0) {
//            if (arr[right] <= b) {
//                num1++;
//            }
//            if (arr[left] >= b) {
//                num2++;
//            }
//            if (num1 == num2) {
//                res++;
//            }
//            right++;
//            left--;
//        }
//
//        System.out.println(res);
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[2 * n + 5];
        int index = -1;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val < b) {
                arr[i] = -1;
            } else if (val > b) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
                index = i;
            }
        }

        int res = 1;
        int s = 0;
        sum[n] = 1;

        for (int i = index - 1; i >= 0; i--) {
            s += arr[i];
            sum[n + s]++;
            if (s == 0) res++;
        }

        s = 0;
        for (int i = index + 1; i < n; i++) {
            s += arr[i];
            res += sum[n - s];
        }

        System.out.println(res);
    }


}
