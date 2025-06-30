import java.util.Scanner;

public class NC0630J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] p = prim(1010);
        for (int i = 0; i < n; i++) {
            arr[i] = p[i] * (i + 1);
            System.out.print(arr[i] + " ");
        }
    }

    static int[] prim(int n) {
        int[] res = new int[n];
        int index = 0;
        for (int i = 1021; i <= 1000000; i += 2) {
            if (isP(i)) {
                res[index++] = i;
            }
            if (index == n) {
                return res;
            }
        }
        return res;
    }

    static boolean isP(int n) {
        boolean res = true;
        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return res;
    }
}
