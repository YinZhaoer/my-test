package model;

public class DLinkNode {


    public int val;

    public int key;

    public DLinkNode pre;

    public DLinkNode next;

    public DLinkNode(int key, int value, DLinkNode next, DLinkNode pre) {
        this.val = value;
        this.key = key;
        this.next = next;
        this.pre = pre;
    }

    public DLinkNode(int key, int value) {
        this.val = value;
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public DLinkNode getPre() {
        return pre;
    }

    public void setPre(DLinkNode pre) {
        this.pre = pre;
    }

    public DLinkNode getNext() {
        return next;
    }

    public void setNext(DLinkNode next) {
        this.next = next;
    }
}
