package top100.linkedlist;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class P_206 {
    //核心是交换每个节点的pre和next

    public static void main(String[] args) {
//        ListNode n4=new ListNode(4,null);
//        ListNode n3=new ListNode(3,n4);
//        ListNode n2=new ListNode(2,n3);
//        ListNode n1=new ListNode(1,n2);
//        reverseNodeList(n1);

        int[] nums = {1, 2, 3};

        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);





    }


        public static List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private static void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;

                    dfs(nums, len, depth + 1, path, used, res);
                    // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }





    public static ListNode reverseNodeList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
