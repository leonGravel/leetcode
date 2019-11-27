package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LevelOrder
 * @Description: 二叉树的层次遍历
 * @Author gravel
 * @Date 2019/11/25
 * @Version V1.0
 *
 * 广度优先搜索，一层层下午
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int len = 1;
        while (!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode cur = queue.poll();
                if(cur!=null){
                    item.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            len = queue.size();
            if(item.size()>0)
            result.add(item);
        }
        return result;
    }

}
