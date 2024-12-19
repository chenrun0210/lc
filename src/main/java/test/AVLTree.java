package test;


public class AVLTree {
    public static  TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        } else {
            return root; // 不插入重复值
        }

        System.out.println(value + "---------");
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // 检查平衡并进行旋转 左子树的高度减去右子树的高度
        int balance = getBalance(root);

        // 左左情况
        if (balance > 1 && value < root.left.val) {
            return rightRotate(root);
        }
        // 左右情况
        if (balance > 1 && value > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 右右情况
        if (balance < -1 && value > root.right.val) {
            return leftRotate(root);
        }
        // 右左情况
        if (balance < -1 && value < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // 返回（未变动的）根节点
    }

    public static int getHeight(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    public static  int getBalance(TreeNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    public static  TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    public static  TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }



    public static void main(String[] args) {
        TreeNode node0 = insert(null,4);
        TreeNode node1 = insert(node0,8);
        TreeNode node2 = insert(node1,12);
        TreeNode node3 = insert(node2,10);
        TreeNode node4 = insert(node3,14);
        TreeNode node5 = insert(node4,15);

        System.out.println(node5);

    }
}
