public class lan2501 {
    public static void main(String[] args) {
        int t = 20240601;
        long pre = 1;
        for (int i = 2; i <= t; i++) {
            long next = (i - 1) * 7;
            next -= 2 * (i - 1) - 1;
            pre += next;
        }
        System.out.println(pre);
    }
}
