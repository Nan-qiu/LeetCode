package leetcode.digitalProblem;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }


    private final Stack<Integer> stack;
    private int min=Integer.MAX_VALUE;
    //private final StringBuilder temp;
    private final PriorityQueue<Integer> queue;

    public MinStack() {
       stack = new Stack<>();
       //temp=new StringBuilder();
       queue=new PriorityQueue<>();

    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
        min=queue.peek();
//        min=Math.min(min,val);
//        temp.append(val);
    }

    public void pop() {
        int pop=stack.pop();
        if (min==pop){
            queue.poll();
            if (queue.isEmpty()) min=Integer.MAX_VALUE;
            else min=queue.peek()==min?min:queue.peek();
        }else queue.remove(pop);
//        temp.deleteCharAt(temp.lastIndexOf(""+pop));
//        if (temp.indexOf(""+pop)==-1) min=findMin(stack);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

//    private int findMin(Stack<Integer> stack){
//        Stack<Integer> help = new Stack<>();
//        int min=Integer.MAX_VALUE;
//        while (!stack.isEmpty()){
//            int cur=stack.pop();
//            min=Math.min(cur,min);
//            help.push(cur);
//        }
//        //复原
//        while (!help.isEmpty()){
//            int cur=help.pop();
//            stack.push(cur);
//        }
//        return min;
//    }
}
