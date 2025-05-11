public class lc0510Q1 {
    public int maxFreqSum(String s) {
        int[] count = new int[26];
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                count[s.charAt(i) - 'a']++;
                max1 = Math.max(max1, count[s.charAt(i) - 'a']);
            } else {
                count[s.charAt(i) - 'a']++;
                max2 = Math.max(max2, count[s.charAt(i) - 'a']);
            }
        }
        return max1 + max2;
    }
}
