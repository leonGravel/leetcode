package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InorderTraversal
 * @Description: TODO
 * @Author gravel
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root,result);
        return result;
    }
    public void inOrder(TreeNode node,List<Integer> result){
        if(node!=null){
            inOrder(node.left,result);
            result.add(node.val);
            inOrder(node.right,result);
        }
    }
}
