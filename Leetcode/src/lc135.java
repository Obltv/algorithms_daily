public class lc135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = n;

        for (int i = 0; i < n; i++) {
            int start = i > 0 && ratings[i - 1] < ratings[i] ? i - 1 : i;

            while (i + 1 < n && ratings[i] < ratings[i + 1]) {
                i++;
            }
            int top = i;

            while (i + 1 < n && ratings[i] > ratings[i + 1]) {
                i++;
            }

            int inc = top - start;
            int dec = i - top;

            ans += (inc * (inc - 1)) / 2 + (dec * (dec - 1)) / 2 + Math.max(inc, dec);
        }

        return ans;
    }
}
