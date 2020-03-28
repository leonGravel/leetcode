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
//        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(nums.length*2,(a,b)->b-a);
        for(int i=nums.length/2-1,end = nums.length-1;i>=0;i--){
            adjust(nums,i,end);
        }

//        for(int i= 0;i<nums.length;i++){
//            queue.add(nums[i]);
//        }
        int result = nums[0];
//        while (queue.size()>nums.length-k){
//            result = queue.poll();
//        }
        for(int i=nums.length-1;i>nums.length-k;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums,0,i);
            result = temp;
        }
        return result;
    }

    private void adjust(int[] nums, int root, int end){
        if(nums==null||nums.length==0) return;
        int leaf = root*2+1;
        while (leaf<=end){
            if(leaf+1<=end&&nums[leaf+1]>nums[leaf]){
                leaf++;
            }
            if(nums[root]>nums[leaf]){
                break;
            }
            int temp = nums[root];
            nums[root] = nums[leaf];
            nums[leaf] = temp;
            root = leaf;
            leaf = leaf*2+1;
        }
    }



    public static void main(String[] args) throws InterruptedException {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,7,4,9,5,6},4));
    }
}
