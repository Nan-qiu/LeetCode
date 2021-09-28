package leetcode.binaryTree;

import java.util.*;

public class BinaryTreeTraversal {

    public static void main(String[] args){
        TreeNode s = new TreeNode(1,new TreeNode(4,new TreeNode(5,null,null),null),new TreeNode(2,new TreeNode(3,null,null),null));
    }

    public static List<Integer> preOrderTraversal(TreeNode root){ //先序遍历  准备一个栈，先把头节点放栈里
        List<Integer> list = new ArrayList<>();             // 当栈不为空，弹出一个元素，把当前节点的右孩子先放进去，再放左孩子，如果存在的话
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop(); //不能连着写 list.add(stack.pop().val)
                list.add(root.val);
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            }
        }
        return list;

    }

    public static List<Integer> inorderTraversal(TreeNode root){// 中序遍历 ，当栈不为空或root不为空时，进入循环
        List<Integer> list = new ArrayList<>();                 // 先把当前节点的左边界全部放到栈里，root==null时，弹出一个节点，root=root的右子树
        Stack<TreeNode> stack = new Stack<>();                  // 在右子树上再把右边界放栈，循环
        if (root != null){
            while (!stack.isEmpty() || root != null) {
                if (root != null){
                    stack.push(root);
                    root = root.left;
                } else{
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }

    public static List<Integer> posOrderTraversal(TreeNode root){//后序遍历 准备两个栈，stack 和 help，先把头节点放stack里
        List<Integer> list = new ArrayList<>();       //当栈不为空，弹出一个元素，再把弹出的元素放在help里
        Stack<TreeNode> stack = new Stack<>();              //最后把help里的弹出，把val加入list
        Stack<TreeNode> help = new Stack<>();
        if (root != null){
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                help.push(root);
                if (root.left != null) stack.push(root.left);
                if (root.right != null) stack.push(root.right);
            }
        }
        while (!help.isEmpty()) {
            int n = help.pop().val;
            list.add(n);
        }
        return list;
    }

    public static List<Integer> LevelTraversal(TreeNode root){//层次遍历 从上到下，从左到右
        Queue<TreeNode> queue = new LinkedList<>();// 队列实现
        List<Integer> help = new ArrayList<>();
        if (root != null){
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                help.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
        }
        return help;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){
        }

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
