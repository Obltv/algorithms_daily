import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CF2052A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        List<int[]> list = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int a = arr[i];
            List<Integer> l = new LinkedList<>();
            for (int j = i - 1; j >= 1; j--) {
                if (arr[j] > a) {
                    if (l.isEmpty() || arr[j] < l.get(l.size() - 1)) {
                        l.add(arr[j]);
                    } else {
                        list.add(new int[]{arr[j], a});
                    }
                }
            }

            for (int u = l.size() - 1; u >= 0; u--) {
                list.add(new int[]{l.get(u), a});
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }


    }
}