package top100;

import model.ListNode;

/**
 * 两数相加
 */
public class P_2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headPre=new ListNode(-1);
        ListNode cur=headPre;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int tmp=0;
        while (l1!=null&&l2!=null){
            int val1=l1.val;
            int val2=l2.val;
            int subSum=(val1+val2+tmp)%10;
            tmp=(val1+val2+tmp)/10;
            ListNode next=new ListNode(subSum);
            cur.next=next;
            cur=next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int val2=0;
            int val1=l1.val;
            int subSum=(val1+val2+tmp)%10;
            tmp=(val1+val2+tmp)/10;
            ListNode next=new ListNode(subSum);
            cur.next=next;
            cur=next;
            l1=l1.next;

        }
        while (l2!=null){
            int val1=0;
            int val2=l2.val;
            int subSum=(val1+val2+tmp)%10;
            tmp=(val1+val2+tmp)/10;
            ListNode next=new ListNode(subSum);
            cur.next=next;
            cur=next;
            l2=l2.next;
        }
        if (tmp!=0){
            cur.next=new ListNode(tmp);
        }
        return headPre.next;
    }
}
