package leetcode;

import leetcode.utils.ListNode;

import java.util.List;

/**
 * @author: ZhaoYin
 * @version: 2019/11/20
 * @description: 19题，删除链表的倒数第N个节点  关键是构造两个节点，相差N位即可，注意特殊情况以及链表长度的计算
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        removeNthFromEnd(node1, 1);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        int count = 0;
        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < n; i++) {
            last = last.next;
            count++;
        }
        while (last != null) {
            count++;
            if (last.next != null) {
                last = last.next;
                first = first.next;
            } else {
                break;
            }
        }
        if (count == n) {
            return head.next;
        }
        first.next = first.next.next == null ? null : first.next.next;
        return head;

    }

}
