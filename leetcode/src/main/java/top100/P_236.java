package top100;

import model.TreeNode;

/**
 * 求二叉树公共祖先
 */
public class P_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root||q==root||root==null){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;

    }

}
