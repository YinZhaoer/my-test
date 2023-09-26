package top100;

import model.ListNode;

public class P_24 {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        reverseList(node1);
        System.out.println(node1.val);

    }

    public static ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    private static ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        //这里res不会变，写出来方便return出去
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }
}
