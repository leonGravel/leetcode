package array;

import java.util.Arrays;

/**
 * @author Gravel
 * @date 2019/9/9.
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (k < 0 || nums.length == 1||k % nums.length==0) {
            return;
        }
        k %= nums.length;
        reverseArray(nums, 0, nums.length-k-1);
        reverseArray(nums, nums.length-k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(e-> System.out.print(e+","));
    }

    private void reverseArray(int[] arr, int begin, int end) {
        int temp;
        int temp_end = end;
        for (int index = begin; index <= (begin + end) / 2; index++) {
            temp = arr[temp_end];
            arr[temp_end] = arr[index];
            arr[index] = temp;
            temp_end--;
        }
    }

    public static void main(String[] args) throws Exception {
        new Rotate().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
