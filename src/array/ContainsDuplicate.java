package array;

/**
 * @author Gravel
 * @date 2019/9/10.
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * <p>
 * 解题思路，使用计数排序，创建一个新数组来计数
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int len = max - min;
        int[] arr = new int[len + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - min]++;
            if (arr[nums[i] - min] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{0, 1, 2, 3, 0, 5, 6, 7, 8}));
    }
}
