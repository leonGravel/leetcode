package trees;

/**
 * @ClassName MaxPathSum
 * @Description: 二叉树中的最大路径和
 * @Author gravel
 * @Date 2019/12/19
 * @Version V1.0
 *
 * 思路：
 * 后序遍历 如果一个节点在最终的计算结果内，那么会有两种情况：
 *         1. 这个节点的左子树或者右子树的最大路径，加上他本身，并向上回溯到根节点，构成了最大路径
 *         2. 此节点的左右子树都在最终的最大路径中, 加上该节点的值构成了最终的最大路径
 *
 *         用一个result记录每次条路径的最大值，从最下层向上回溯，每次递归记录，当前节点左右子树中的最大路径值
 *         并用后序遍历向上回溯。
 **/
public class MaxPathSum {

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return result;
    }
    private int getMaxPathSum(TreeNode node){
        if(node==null) {
            return 0;
        }
        int leftMax = Math.max(0,getMaxPathSum(node.left));
        int rightMax = Math.max(0,getMaxPathSum(node.right));
        result = Math.max(result,node.val+leftMax+rightMax);
        return Math.max(leftMax,rightMax)+node.val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right= new TreeNode(9);
        node.left.left= new TreeNode(10);
        System.out.println(new MaxPathSum().maxPathSum(node));
    }
}
