package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-14 10:57
 */
public class SameTree {
    public static void main(String[] args) {


    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
