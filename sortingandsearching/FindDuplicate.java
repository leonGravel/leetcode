package sortingandsearching;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindDuplicate
 * @Description: TODO
 * @Author gravel
 * @Date 2019/12/28
 * @Version V1.0
 **/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length, 1);
        int result = 0;
        for (int i : nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                result = i;
                break;
            }
        }
        return result;
    }

    public int findDuplicate1(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1,2,4,4,5,6}));
    }
}
