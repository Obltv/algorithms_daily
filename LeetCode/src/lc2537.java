import java.util.*;
/*
解题思路
核心观察
相等对数的计算：如果一个数字 x 在子数组中出现 c 次，那么它能贡献的相等对数为组合数 C(c, 2) = c * (c - 1) / 2。

滑动窗口的适用性：

子数组的连续性要求适合用滑动窗口处理。

当窗口扩大（右指针右移）时，窗口内的相等对数不会减少；当窗口缩小（左指针左移）时，相等对数不会增加。这种单调性使得滑动窗口可以高效地维护满足条件的区间。

滑动窗口法
维护窗口：使用双指针 left 和 right 表示当前窗口的左右边界。

统计频次：使用哈希表 cnt 记录窗口中每个数字的出现次数。

动态计算对数：

当数字 x 加入窗口时，新增的相等对数等于 x 在窗口中已存在的次数 cnt[x]。

当数字 x 移出窗口时，减少的相等对数等于 x 在窗口中剩余的次数 cnt[x] - 1。

结果统计：

当窗口的对数 pairs 首次满足 pairs >= k 时，所有以 right 结尾的子数组中，左边界在 [0, left] 的都满足条件（因为更小的左边界会包含更多元素，对数只会更多）。

因此，可以直接累加 left 的值到结果中，避免重复检查。

class Solution {
    public long countGood(int[] nums, int k) {
        // 最终结果
        long res = 0;
        // 当前窗口中的相等对数
        int pairs = 0;
        // 滑动窗口的左边界
        int left = 0;
        // 哈希表记录窗口中各数字的出现次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，右边界right从0到n-1
        for (int num : nums) {
            // 获取当前数字在窗口中的出现次数
            int count = map.getOrDefault(num, 0);
            // 每新增一个相同数字，会增加count个新对数
            pairs += count;
            // 更新当前数字的出现次数
            map.put(num, count + 1);

            // 当对数满足条件时，收缩左边界
            while (pairs >= k) {
                // 获取左边界数字的出现次数
                int leftNum = nums[left];
                int leftCount = map.get(leftNum);
                // 移除左边界数字会减少leftCount-1个对数
                pairs -= leftCount - 1;
                // 更新左边界数字的出现次数
                map.put(leftNum, leftCount - 1);
                // 左边界右移
                left++;
            }

            // 关键点解释：
            // 对于当前右边界，所有left左边的位置作为起始点的子数组都满足条件
            // 因为如果left>0，说明[left-1,right]已经满足条件，那么[0,right],[1,right],...,[left-1,right]都满足
            // 所以可以直接累加left的值
            res += left;
        }

        return res;
    }
}
 */
public class lc2537 {
    public long countGood(int[] nums, int k) {
        //res是结果
        int res = 0;
        //记录对数
        int pairs = 0;
        //滑动窗口🪟左端
        int left = 0;
        //Hash Map存数目
        Map<Integer, Integer> map = new HashMap<>();
        //遍历
        for (int num : nums) {
            int a = map.getOrDefault(num, 0);
            pairs += a;
            map.put(num, a + 1);
            while (pairs >= k) {
                int b = map.getOrDefault(nums[left], 0);
                //是b-1，其实就相当于反着来
                pairs -= b - 1;
                map.put(nums[left], b - 1);
                left++;
            }
            //这里有点不理解要是没满足条件为什么还要加
            //理解了，因为你把right++后即使没有满足条件，那么也可以想象将left--后它肯定满足，其实就相当于将窗口延长了，但是没有改变它每次延长加的个数
            res += left;
        }
        return res;
    }
}
