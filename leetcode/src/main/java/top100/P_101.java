package top100;

import model.TreeNode;

/**
 * 对称二叉树
 */
public class P_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode right, TreeNode left) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
    }


}
