package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 * 思路：因为所有数组元素的值都是小于等于数组长度的，所以可以利用这个特性
 * 启动一个指针，从从开始扫描，当扫描到i时，如果i和当前元素相等，则指针后移，继续扫描
 * 如果不相等，则用当前元素的值作为下标，去找这个数组对应的值，如果相等，则我们找到了一个重复元素，如果不想等，则交换两者的值
 * 指针不要后移，继续扫描
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; ) {
            int target = nums[i - 1];
            if (i != target) {
                if (nums[target - 1] == target) {
                    if (!result.contains(target)) {
                        result.add(target);
                    }
                    i++;
                } else {
                    nums[i - 1] = nums[target - 1];
                    nums[target - 1] = target;
                }
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new FindDuplicates().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).
                forEach(integer -> System.out.print(integer + ","));
    }
}
