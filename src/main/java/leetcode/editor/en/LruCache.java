//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class Node {
            private int k;
            private int v;
            private Node p;
            private Node n;

            public Node(int k, int v) {
                this.k = k;
                this.v = v;
            }
        }

        private int capacity = 0;
        private Map<Integer, Node> map;
        private Node h;
        private Node t;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            h = new Node(0, 0);
            t = new Node(0, 0);
            h.n = t;
            t.p = h;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.v;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(h.n);
            }
            insert(new Node(key, value));
        }

        private void insert(Node node) {
            map.put(node.k, node);
            Node p = t.p;
            p.n = node;
            node.p = p;
            node.n = t;
            t.p = node;
        }

        private void remove(Node node) {
            map.remove(node.k);
            Node p = node.p;
            Node n = node.n;
            p.n = n;
            n.p = p;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
