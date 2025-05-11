public class lc2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long count1 = 0;
        long count2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            if (nums1[i] == 0) {
                count1++;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if (nums2[i] == 0) {
                count2++;
            }
        }

        if(count1==0&&sum1<sum2+count2){
            return -1;
        }
        if(count2==0&&sum2<sum1+count1){
            return -1;
        }

        return Math.max(sum1 + count1, sum2 + count2);
    }
}
