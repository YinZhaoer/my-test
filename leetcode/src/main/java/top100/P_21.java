package top100;

import model.ListNode;

/**
 * 合并两个有序链表
 */
public class P_21 {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head=list1.val <=list2.val ?list1:list2;
        ListNode cur1=list1==head?list1:list2;
        ListNode cur2=list2==head?list1:list2;
        ListNode pre=null;
        while (cur1!=null&&cur2!=null){
            if(cur1.val <=cur2.val){
                pre=cur1;
                cur1=cur1.next;
            }else {
                pre.next=cur2;
                cur2.next=cur1;
                pre=cur2;
                cur2=cur2.next;
            }
        }
        pre.next=cur1==null?cur2:cur1;
        return head;

    }


}
