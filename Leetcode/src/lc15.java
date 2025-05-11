import java.util.*;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            List<List<Integer>> list = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> list1 : list) {
                list1.add(nums[i]);
                res.add(list1);
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int a = nums[left], b = nums[right];
            int sum = a + b;
            if (sum > target) {
                while (left < right && nums[right] == b) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == a) left++;
            } else {
                ans.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                while (left < right && nums[right] == b) right--;
                while (left < right && nums[left] == a) left++;
            }
        }
        return ans;
    }
}
