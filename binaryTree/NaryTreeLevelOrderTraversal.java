package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root){
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            ArrayList<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node poll = list.poll();
                cur.add(poll.val);
                if (poll.children != null){
                    list.addAll(poll.children);
                }
            }
            res.add(cur);
        }
        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node(){
        }

        public Node(int _val){
            val = _val;
        }

        public Node(int _val, List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    ;
}
