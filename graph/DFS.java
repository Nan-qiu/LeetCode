package leetcode.graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node){ // Deep First Search 深度优先遍历
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);// 做操作
        while (!stack.isEmpty()) {
            node = stack.pop();
            for(Node next : node.nexts){
                if (!set.contains(node)){
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value); // 做操作
                    break;
                }
            }
        }
    }
}
