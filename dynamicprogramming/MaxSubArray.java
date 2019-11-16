package dynamicprogramming;

/**
 * @ClassName MaxSubArray
 * @Description: 最大子序和
 * @Author gravel
 * @Date 2019/11/17
 * @Version V1.0
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 * 思路： 定义指针i, 从第二位开始遍历，如果第一位大于0，那么前两位数组的最大子序就是第一位+第二位
 * 如果小于零，那么就是第二位和前面最小子序做比较，取最大值。
 * 依次类推
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i=1;i<nums.length;++i){
            dp[i] = Math.max(dp[i-1],0)+nums[i];
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{1,2,3,4,5,-4,3,-6}));
    }
}
