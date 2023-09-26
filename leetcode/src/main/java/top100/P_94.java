package top100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 */
public class P_94 {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public static void traversal(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        traversal(root.left,res);
        res.add(root.val);
        traversal(root.right,res);
    }
}
