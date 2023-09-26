package top100;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍历
 */
public class P_102 {

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        levelOrder(node1);
        System.out.println(1);



    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        List<TreeNode> nodeList=new ArrayList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()){
            List<Integer> levelRes=new ArrayList<>();
            List<TreeNode> childNodeList=new ArrayList<>();
            for(int i=0;i<nodeList.size();i++){
                TreeNode node=nodeList.get(i);
                levelRes.add(node.val);
                if(node.left!=null){
                    childNodeList.add(node.left);
                }
                if(node.right!=null){
                    childNodeList.add(node.right);
                }
            }
            res.add(levelRes);
            nodeList=childNodeList;
        }
        return res;
    }
}
