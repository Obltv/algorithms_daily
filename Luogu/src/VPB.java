import java.util.Scanner;

public class VPB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            String sub = s.substring(0, s.length() - 1);
            System.out.println(sub);
        } else {
            String sub = s.substring(0, index) + s.substring(index + 1);
            System.out.println(sub);
        }
    }

}
