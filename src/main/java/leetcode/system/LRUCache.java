package leetcode.system;

import java.util.HashMap;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-07-02
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));

    }

    public DoubleList cache;
    public HashMap<Integer, Node> map;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 获取缓存数据
    public int get(int key) {
        if (map.containsKey(key)) {
            // 把key放到首位
            Node hit = map.get(key);
            cache.remove(hit);
            cache.addFirst(hit);
            return hit.val;
        } else {
            return -1;
        }

    }

    // 往缓存里放数据。lru，要判断是不是满了,判断原来是不是有
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            Node hit = map.get(key);
            cache.remove(hit);
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cache.size == cap) {
                Node last = cache.removeLast();
                cache.addFirst(x);
                map.remove(last.key);
            } else {
                cache.addFirst(x);
            }
            map.put(key, x);
        }

    }


    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    static class DoubleList {
        private Node dummyHead;// 伪头结点
        private Node dummyTail;//伪尾结点
        public int size;

        public DoubleList() {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node n) {
            Node first = dummyHead.next;
            first.prev = n;
            n.next = first;
            n.prev = dummyHead;
            dummyHead.next = n;
            size++;
        }


        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node n) {
            Node pre = n.prev;
            Node next = n.next;
            pre.next = next;
            next.prev = pre;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node last = dummyTail.prev;
            remove(last);
            return last;
        }
    }
}
