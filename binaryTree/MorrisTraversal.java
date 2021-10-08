package leetcode.binaryTree;

public class MorrisTraversal { // 二叉树遍历最优解

    public static void morris(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) { // 进入流程
            mostRight = cur.left;
            if (mostRight != null){// cur有左子树
                while (mostRight.right != null && mostRight.right != cur) { // 来到左子树的最右节点
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){// first come to mostRight point
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else mostRight.right = null; // if mostRight.right is not null,it must be cur.
            }
            cur = cur.right;
        }
    }

    //先序遍历
    public static void morrisPre(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            // cur表示当前节点，mostRight表示cur的左孩子的最右节点
            mostRight = cur.left;
            if (mostRight != null){
                // cur有左孩子，找到cur左子树最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight的右孩子指向空，让其指向cur，cur向左移动
                if (mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else{
                    // mostRight的右孩子指向cur，让其指向空，cur向右移动
                    mostRight.right = null;
                }
            } else{
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    //中序遍历
    public static void morrisIn(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else{
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    //----------------后序遍历----------------
    public static void morrisPos(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else{
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(TreeNode node){
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode node){
        TreeNode pre = null;
        TreeNode next;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    //----------------------------------
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(){
        }

        TreeNode(int value){
            this.value = value;
        }

        TreeNode(int value,TreeNode left,TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
