public class lc2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long s = 0, minS = 0, maxS = 0;
        for (int num : differences) {
            s += num;
            minS = Math.min(s, minS);
            maxS = Math.max(s, maxS);
        }
        return (int) Math.max(0, upper - lower - maxS + minS + 1);
    }
}
