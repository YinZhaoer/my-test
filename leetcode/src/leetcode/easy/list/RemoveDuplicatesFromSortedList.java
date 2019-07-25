package leetcode.easy.list;

import leetcode.utils.ListNode;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-17 9:48
 */
//排序链表去重
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(4);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(deleteDuplicates(head));
        System.out.println("Finshed");



    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null&&temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;//注意此时temp的引用已经和head不同了，不会影响head本身
            }
        }
        return head;

    }
}
