package top100;

import model.ListNode;

/**
 * 反转链表
 */
public class P_206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseList(node1);

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp=null;
        while (cur != null) {
            tmp=cur.next;
            cur.next = pre;
            pre = cur;
            cur =tmp;

        }
        return pre;

    }

}
