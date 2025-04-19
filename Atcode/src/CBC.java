import java.util.Scanner;

public class CBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='Z'&&s.charAt(i)>='A'){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
