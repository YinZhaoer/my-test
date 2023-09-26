package top100;

import model.TreeNode;

/**
 * 根节点到叶子节点的路径和
 */
public class P_129 {

    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    public int help(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }
        i = i * 10 + node.val;
        if (node.left == null && node.right == null){
            return i;
        }
        return help(node.left, i) + help(node.right, i);
    }

}
