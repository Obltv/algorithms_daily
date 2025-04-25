import java.util.PriorityQueue;

public class lc912 {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int num:nums){
            q.offer(num);
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=q.poll();
        }
        return nums;
    }
}
