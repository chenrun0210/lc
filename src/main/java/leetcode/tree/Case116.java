package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case116 {

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        Case116 case116 = new Case116();
        case116.connect(root);
    }
    // 标准答案  每一次需要把队列里的所有元素都拿出来
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }


    // 层次遍历基于广度优先搜索，它与广度优先搜索的不同之处在于，广度优先搜索每次只会取出一个节点来拓展，而层次遍历会每次将队列中的所有元素都拿出来拓展，这样能保证每次从队列中拿出来遍历的元素都是属于同一层的，因此我们可以在遍历的过程中修改每个节点的
    //next
    //next 指针，同时拓展下一层的新队列。
    //
    //
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> layer = new LinkedList<>();
        Queue<Node> result = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            if (cur == null) continue;
            if (cur.left != null) {
                layer.offer(cur.left);
                layer.offer(cur.right);
            }
            while (!queue.isEmpty()) {
                cur = queue.poll();
                result.add(cur);
                if (cur == null) continue;
                if (cur.left != null) {
                    layer.offer(cur.left);
                    layer.offer(cur.right);
                }

            }
            queue.add(null);
            queue.addAll(layer);
            layer.clear();
        }

        while (!result.isEmpty()) {
            Node cur = result.poll();
            if (cur == null) ;
            else {
                cur.next = result.peek();
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
