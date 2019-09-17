package array;

import utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gravel
 * @date 2018/6/26.
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *  思路：使用hash表，在hash表中，存储数据的value 以及index,然后再次遍历数组，通过判断target-当前数组元素的结果是否在hash
 *  表中存在。来得到另一个数
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                return new int[]{i,map.get(temp)};
            }
        }
        return new int[2];
    }
    public static void main(String[] args) throws Exception {
        CommonUtils.printArr(new TwoSum().twoSum(new int[]{3, 2, 4}, 6));
    }
}
