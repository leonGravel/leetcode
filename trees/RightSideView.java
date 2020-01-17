package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName RightSideView
 * @Description: 二叉树的右视图
 * @Author gravel
 * @Date 2019/12/19
 * @Version V1.0
 * 思路：
 * 宽度优先遍历，打印每一层的第一个数字，这里如果用深度优先遍历的话，不好判断是否是该列第一个
 **/

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int len = 1;
        while (!queue.isEmpty()){
            int j = 0;
            for(int i=0;i<len;i++){
                TreeNode cur = queue.poll();
                if(cur!=null){
                    queue.add(cur.right);
                    queue.add(cur.left);
                    j++;
                }
                // 每层只取第一个数字
                if(j==1){
                    result.add(cur.val);
                }
            }
            len = queue.size();
        }
        return result;
    }

}
