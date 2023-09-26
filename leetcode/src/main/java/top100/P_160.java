package top100;


import model.ListNode;

/**
 * 相交链表
 */
public class P_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1=headA;
        ListNode cur2=headB;
        if(cur1==cur2){
            return cur1;
        }

        while (cur1.next!=null||cur2.next!=null){
            if(cur1==cur2){
                return cur1;
            }
            if(cur1.next==null){
                cur1=headA;
            }else {
                cur1=cur1.next;
            }
            if(cur2.next==null){
                cur2=headB;
            }else {
                cur2=cur2.next;
            }
        }
        return cur1==cur2?cur1:null;

    }
}
