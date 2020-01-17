package trees;


import java.util.LinkedList;

/**
 * @ClassName MaxDepth
 * @Description: 求二叉树的深度
 * @Author gravel
 * @Date 2019/11/24
 * @Version V1.0
 *
 * 深度优先遍历和广度优先遍历。。不过这一题，我觉得最好还是深度优先遍历
 **/
public class MaxDepth {
    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //递归获取左子树高度
            int l = maxDepth(root.left);
            //递归获取右子树高度
            int r = maxDepth(root.right);
            //高度应该算更高的一边，（+1是因为要算上自身这一层）
            return l>r? (l+1):(r+1);
        }
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int depth = 0;
        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            TreeNode curNode = cur.node;
            int curLevel = cur.level;
            if(curNode!=null){
                depth = Math.max(curLevel,depth);
                queue.add(new Pair(curNode.left, curLevel + 1));
                queue.add(new Pair(curNode.right, curLevel + 1));
            }
        }
        return depth;
    }

    static class Pair {
        TreeNode node;
        Integer level;
        public Pair(TreeNode node,Integer level){
            this.node = node;
            this.level=level;
        }
    }
}
