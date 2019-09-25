package array;

import java.util.Arrays;

/**
 * @author Gravel
 * @date 2019/9/17.
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if(Arrays.stream(digits).filter(e->e==9).count()==length){
            int[] newArr = new int[length + 1];
            addOne(digits, length - 1);
            newArr[0]++;
            return newArr;
        }
        addOne(digits, length - 1);
        return digits;
    }

    private void addOne(int[] nums, int index) {
        if (index < 0) return;
        nums[index]++;
        if (nums[index] == 10) {
            if (index == 0) {
                nums[index] = 1;
                return;
            }
            nums[index] = 0;
            addOne(nums, index - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new PlusOne().plusOne(new int[]{9, 9}));
    }
}
