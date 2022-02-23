package leetcode.digitalProblem;

import java.util.Stack;

public class OneBitAndTwoBitCharacters {
    public static void main(String[] args){
        int[] a = {1,1,1,0};
        System.out.println(isOneBitCharacter(a));
    }

    public static boolean isOneBitCharacter(int[] bits){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < bits.length; i++){
            stack.push(bits[i]);
            if (i == bits.length - 1){
                if (stack.size() == 1){
                    return stack.pop() == 0;
                }
                return false;
            }
            if (stack.size() == 1 && stack.peek() == 0){
                stack.pop();
            } else if (stack.size() == 2){
                stack.pop();
                stack.pop();
            }
        }
        return false;
    }
}
