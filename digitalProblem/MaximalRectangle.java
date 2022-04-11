package leetcode.digitalProblem;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix){
        int[][] tem = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            tem[0][i] = matrix[0][i] - '0';
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != '0'){
                    tem[i][j] = matrix[i][j] - '0' + tem[i - 1][j];
                }
            }
        }
//        for(int[] ints : tem){
//            System.out.println(Arrays.toString(ints));
//        }
        int res = 0;
        for(int[] ints : tem){
            res = Math.max(res, help(ints));
        }
        return res;
    }

    public int help(int[] heights){
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int res = 0;
        int[] newHeights = new int[heights.length + 2];
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
}
