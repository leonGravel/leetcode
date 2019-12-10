package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MajorityElement
 * @Description: TODO
 * @Author gravel
 * @Date 2019/12/10
 * @Version V1.0
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int mid = nums.length/2;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.getOrDefault(i,0)>mid) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{}));
    }
}
