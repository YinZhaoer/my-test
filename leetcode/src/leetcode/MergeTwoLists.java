package leetcode;

import leetcode.utils.ListNode;

/**
 * @author: ZhaoYin
 * @version: 2019/11/21
 * @description: 21题，合并两个有序列表,注意考虑边界条件,(1次过，我好强)
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while(l1!=null&&l2!=null){
            int var1=l1.val;
            int var2=l2.val;
            if(var1<var2){
               temp.next=new ListNode(var1);
                l1=l1.next;
            }else{
                temp.next=new ListNode(var2);
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1==null){
            temp.next=l2;
        }else{
            temp.next=l1;
        }

        return head.next;

    }
}
