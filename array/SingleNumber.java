package array;

/**
 * @author Gravel
 * @date 2019/9/10.
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 解题思路，异或运算
 * 何数与 0 异或都不改变它的值，即 a⊕0=a
 * 任何数与其自身异或都为 0，即 a⊕a=0
 * 由于除了某个元素只出现一次以外，其余每个元素均出现两次
 * 所以，依此进行异或操作，最终剩下的值，即可那个单个的值
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new SingleNumber().singleNumber(new int[]{2,2,1}));
    }
}
