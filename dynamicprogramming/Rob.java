package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Rob
 * @Description: 打家劫舍
 * @Author gravel
 * @Date 2019/11/22
 * @Version V1.0
 * <p>
 * 思路：用f(n)表示包含n本身的间隔相加最大值，最后的答案，肯定是等于 Max(f(n),f(n-1))，因为n和n-1，必然有一个数参与了相加
 * 那么依次内推，f(n) = max(f(n-2),f(n-3))+nums[n]
 * 定义特殊的前两个数，用两个集合存储n和n-1这两条线路，依次加上来的每一个值。
 * 然后遍历，套入这个公式，注意一下边界问题
 **/
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int first = 0;
        int second = nums[0];//第一个数

        int n = 1;

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        firstList.add(first);
        secondList.add(second);
        while (n < nums.length) {
            if (n == 1) {
                first = Math.max(nums[0], nums[1]);
            } else {
                first = Math.max(first, secondList.get(secondList.size() - 2)) + nums[n];
            }
            firstList.add(first);
            if (n + 1 < nums.length)
                second = Math.max(firstList.get(firstList.size() - 2), second) + nums[n + 1];

            secondList.add(second);

            n += 2;
        }

        return Math.max(first, second);
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
