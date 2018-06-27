/**
 * Created by gravel on 2018/6/26.
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while (i<j){
            int temp = nums[i]+nums[j];
            if(temp==target){
                return new int[]{i,j};
            }else if(temp>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[2];
    }
    public static void main(String[] args) throws Exception {
        int[] nums = {3, 2, 4};
        int[] result = new TwoSum().twoSum(nums, 6);
        for (int i : result)
            System.out.println(i);
    }
}
