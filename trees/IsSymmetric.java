package trees;


/**
 * @ClassName IsSymmetric
 * @Description: 对称二叉树
 * @Author gravel
 * @Date 2019/11/25
 * @Version V1.0
 *
 * 思路：看到这个题目第一眼，就是中序遍历，压栈，验证栈是否是回文对称..
 *
 * 但是这么做会有一个问题，当树形结构是[1,2,2,2,null,2] 时，会有错
 *
 * 翻转二叉树，不断遍历比较左右子树的节点是否相等
 **/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode n1,TreeNode n2) {
        if(n1==null&&n2==null) return true;
        if(n1==null||n2==null) return false;
        return (n1.val==n2.val)&&isMirror(n1.left,n2.right)&&isMirror(n2.right,n1.left);
    }
    public static void main(String[] args) {

    }
}
