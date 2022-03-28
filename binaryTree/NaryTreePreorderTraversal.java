package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if(root==null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur=stack.pop();
            if (cur.children!=null){
                for(int i = cur.children.size()-1; i >=0; i--){
                    stack.push(cur.children.get(i));
                }
            }
            res.add(cur.val);
        }
        return res;
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
