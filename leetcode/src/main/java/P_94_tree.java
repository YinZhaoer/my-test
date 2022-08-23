import java.util.ArrayList;
import java.util.List;

public class P_94_tree {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    static List<Integer> res=new ArrayList<>();


    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        traverse(root);
        return res;
    }



    public static void traverse(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        traverse(treeNode.left);
        res.add(treeNode.val);
        traverse(treeNode.right);
    }


}
