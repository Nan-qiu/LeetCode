package leetcode.stringProblem;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args){
        LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();
        int[] a = {2, 1, 2};
        System.out.println(largestRectangleinHistogram.largestRectangleArea1(a));
    }

    //单调栈
    public int largestRectangleArea1(int[] heights){
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int res = 0;
        int[] newHeights = new int[heights.length + 2];
        //首尾各加一个哨兵
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i = 1; i < newHeights.length; i++){
            int height = newHeights[i];
            while (newHeights[stack.peek()] > height) {
                //栈顶柱子的下标
                int pop = stack.pop();
                //当前弹出元素的上一个，是左边界
                int peek = stack.peek();
                //i就是右边界，右边界 - 左边界再 -1 就是当前高度的柱子能够达到的最大宽度
                res = Math.max(res, newHeights[pop] * (i - peek - 1));
            }
            stack.add(i);
        }
        return res;
    }


    //暴力：超时
    public int largestRectangleArea(int[] heights){
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if (heights[i] == 0) continue;
            int cur = heights[i];
            int sum = 0;
            sum = cur;
            //朝右找
            for(int j = i + 1; j < heights.length; j++){
                int nextH = heights[j];
                if (nextH != 0 && nextH >= cur){
                    sum = Math.max(sum, cur * (j - i + 1));
                    //res = Math.max(res, cur + cur);
                } else break;
            }

            for(int j = i - 1; j >= 0; j--){
                int nextH = heights[j];
                if (nextH != 0 && nextH >= cur){
                    sum = Math.max(sum, sum + cur);
                } else break;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

}
