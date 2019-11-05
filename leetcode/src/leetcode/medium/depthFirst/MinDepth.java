package leetcode.medium.depthFirst;

import leetcode.utils.TreeNode;

/**
 * 题目111
 */
public class MinDepth {
    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        int depth=0;
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minDepth=Integer.MAX_VALUE;
        if(root.left!=null){
            return Math.min(minDepth,minDepth(root.left));
        }
        if(root.right!=null){
            return Math.min(minDepth,minDepth(root.right));
        }
        return minDepth+1;

    }
}
