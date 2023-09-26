package top100;

import model.ListNode;

/**
 * 反转链表2
 */
public class P_92 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        reverseBetween(node1, 1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode headfirst = new ListNode(-1);
        headfirst.next = head;

        ListNode pre = null;
        ListNode tmp = null;
        ListNode cur = head;
        ListNode leftPre = headfirst;
        ListNode rightNext = null;
        ListNode leftNode = null;
        ListNode rightNode = null;

        if(left==right){
            return head;
        }
        while (cur != null && i <= left) {
            if (i == left - 1) {
                leftPre = cur;
            }
            if (i == left) {
                leftNode = cur;
            }
            pre = cur;
            cur = cur.next;
            i++;
        }
        if(cur==null){
            return head;
        }
        while (cur != null && i <= right) {
            if (i == right) {
                rightNode = cur;
                rightNext = cur.next;
            }
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            i++;
        }

        leftPre.next = rightNode;
        leftNode.next = rightNext;
        return headfirst.next;


    }

}
