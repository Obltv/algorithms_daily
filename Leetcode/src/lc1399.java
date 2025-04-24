public class lc1399 {
    public int countLargestGroup(int n) {
        int[] arr = new int[n + 1];
        int max = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int a = toSum(i);
            arr[a]++;
            max = Math.max(max, arr[a]);
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == max) {
                res++;
            }
        }
        return res;
    }

    public int toSum(int m) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }

}
