package linkedlist;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName FindKthLargest
 * @Description: 数组中的第K个最大元素
 * @Author gravel
 * @Date 2019/12/15
 * @Version V1.0
 * 思路：
 * 将数据一次放入一个优先队列排序，然后依次出队，第k个出队的，就是第k个最大的元素
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k)  {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(nums.length*2,(a,b)->b-a);
        for(int i= 0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int result = nums[0];
        while (queue.size()>nums.length-k){
            result = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,7,4,9,5,6},4));
    }
}
