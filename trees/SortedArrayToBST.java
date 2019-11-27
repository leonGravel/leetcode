package trees;

/**
 * @ClassName SortedArrayToBST
 * @Description: 将有序数组转换为二叉搜索树
 * @Author gravel
 * @Date 2019/11/27
 * @Version V1.0
 * <p>
 * 二分查找+递归，
 **/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        return setVal(nums, 0, nums.length - 1);

    }

    TreeNode setVal(int[] nums, int left, int right) {
        if (left > right) return null;//定义的二分区间为[left,right]，无法进行继续递归，直接退出
        int mid = (left + right) >>> 1;//二分中值
        TreeNode root = new TreeNode(nums[mid]);
        root.left = setVal(nums, left, mid - 1);//注意mid-1 对左半部分进行递归
        root.right = setVal(nums, mid + 1, right);//注意mid+1 对右半部分进行递归
        return root;
    }

    public static void main(String[] args) {
        new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
