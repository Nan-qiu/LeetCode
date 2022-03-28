package leetcode.binaryTree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(BinaryTreeTraversal.TreeNode root){
        Queue<BinaryTreeTraversal.TreeNode> queue = new LinkedList<>();// 队列实现
        List<List<Integer>> help = new ArrayList<>();
        if (root != null){
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int cursize = queue.size(); // 锁定长度，在循环的时候不变
                for(int i = 0; i < cursize; i++){
                    root = queue.poll();
                    level.add(root.val);
                    if (root.left != null){
                        queue.add(root.left);
                    }
                    if (root.right != null){
                        queue.add(root.right);
                    }
                }
                help.add(level);
            }
        }
        return help;
    }
}
