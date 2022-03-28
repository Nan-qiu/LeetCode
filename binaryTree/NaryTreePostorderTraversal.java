package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//后续
public class NaryTreePostorderTraversal {

    public List<Integer> postorder1(Node root){
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        recur(root,res);
        return res;
    }

    private void recur(Node root,ArrayList<Integer> res){
        if (root==null) return;
        for(Node child : root.children){
            recur(child,res);
        }
        res.add(root.val);
    }

    //=============================================================
    public List<Integer> postorder(Node root){
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            help.push(pop);
            if (pop.children != null){
                for(Node child : pop.children){
                    stack.push(child);
                }
            }
        }
        while (!help.isEmpty()) {
            int val = help.pop().val;
            res.add(val);
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

        public Node(int _val,List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    ;
}
