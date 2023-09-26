package top100;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表2
 * 核心是 fast=2slow
 *  fast= a+n(b+c)+b=2(a+b)
 *  a为环前路径，b为环起点与相遇点之间，c为相遇点到环前，n为相遇时fast走完的圈数
 *  a=c+(n-1)(b+c)
 *  b+c是环的长度，所以，当头结点走a时，slow节点相当于走了c+（n-1）圈，刚好在入环的地方
 *
 */
public class P_142 {

    public ListNode detectCycleFastSlow(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        slow = slow.next;
        if (fast.next == null) {
            return null;
        }
        fast = fast.next.next;
        while (fast != slow && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp != slow) {
            slow = slow.next;
            tmp = tmp.next;
        }
        return tmp;


    }


    public ListNode detectCycleHash(ListNode head) {
        Set<ListNode> filter = new HashSet<>();

        ListNode cur = head;
        while (cur != null && !filter.contains(cur)) {
            filter.add(cur);
            cur = cur.next;
        }
        return cur;

    }
}
