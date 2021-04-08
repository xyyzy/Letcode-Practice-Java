package 最热100题._146_LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }


        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    public DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null)
            return -1;
        //如果存在则将其移到头部并返回
        moveToHead(node);
        return node.value;
    }



    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node==null){
            //如果key不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进hash表
            cache.put(key,newNode);
            //添加到双向链表的头部
            addToHead(newNode);
            ++size;
            //超出容量
            if (size>capacity){
                //超出容量删除双向链表节点
                DLinkedNode tail = removeTail();
                //删除cahce中的对应项
                cache.remove(tail.key);
                --size;
            }
        }
        //如果已经有这个节点，先通过hash表定位，修改value，然后将其移动到头结点
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }



}
