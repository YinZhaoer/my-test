package top100;

import model.DLinkNode;


import java.util.HashMap;
import java.util.Map;

/**
 * LRU
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(2));


    }



    Map<Integer, DLinkNode> indexMap=new HashMap<>();
    int capacity;
    DLinkNode head=new DLinkNode(0,0);
    DLinkNode tail=new DLinkNode(0,0);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.indexMap=new HashMap<>(capacity);
        head.pre=null;
        head.next=tail;
        tail.pre=head;
        tail.next=null;
    }

    public int get(int key) {
        if(indexMap.containsKey(key)){
            DLinkNode node=indexMap.get(key);
            move2Head(node);
            return node.val;
        }else {
            return -1;
        }
    }

    private void move2Head(DLinkNode node){
        node.next.pre=node.pre;
        node.pre.next=node.next;
        add2Head(node);
    }

    private void removeTail(){
        DLinkNode realTail=tail.pre;
        indexMap.remove(realTail.key);
        realTail.pre.next=tail;
        tail.pre=realTail.pre;
    }


    private void add2Head(DLinkNode node){
       head.next.pre=node;
       node.next=head.next;
       head.next=node;
       node.pre=head;

    }

    public void put(int key, int value) {
        DLinkNode node=null;
       if(indexMap.containsKey(key)){
            node=indexMap.get(key);
           node.val=value;
           move2Head(node);
       }else {
           node=new DLinkNode(key,value);
           if(indexMap.size()==capacity){
               removeTail();
               add2Head(node);
           }else {
               add2Head(node);
           }
       }
       indexMap.put(key,node);

    }
}
