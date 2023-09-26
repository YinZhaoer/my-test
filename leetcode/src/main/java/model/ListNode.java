package model;

public class ListNode {

    public int val;

    public  ListNode pre;

    public  ListNode next;

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public ListNode(int value) {
        this.val = value;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
