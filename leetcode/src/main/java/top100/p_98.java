package top100;

import model.TreeNode;

/**
 * 验证二叉树
 */
public class p_98 {

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(left!=null&&left.val>=root.val){
            return false;
        }
        if(right!=null&&right.val<= root.val){
            return false;
        }
        return isValidBST(right)&&isValidBST(left);
    }


}
