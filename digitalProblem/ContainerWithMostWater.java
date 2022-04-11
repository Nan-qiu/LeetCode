package leetcode.digitalProblem;


public class ContainerWithMostWater {


    public int maxArea(int[] height){
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }

//    public int maxArea(int[] height){
//        int[][] dp = new int[height.length][height.length];
//        for(int[] ints : dp){
//            Arrays.fill(ints, -1);
//        }
//        return process1(height, 0, height.length - 1, dp);
//    }


    //memory search 爆内存
    private int process1(int[] height, int start, int end, int[][] dp){
        if (dp[start][end] != -1) return dp[start][end];
        if (start >= end){
            dp[start][end] = 0;
            return 0;
        } else if (height[start] == 0) return process1(height, start + 1, end, dp);
        else if (height[end] == 0) return process1(height, start, end - 1, dp);

        int area = Math.min(height[start], height[end]) * (end - start);
        int p1 = process1(height, start + 1, end, dp);
        int p2 = process1(height, start, end - 1, dp);
        int p3 = process1(height, start + 1, end - 1, dp);
        dp[start][end] = Math.max(area, Math.max(p1, Math.max(p2, p3)));
        return dp[start][end];
    }

    //force
    private int process(int[] height, int start, int end){
        if (start >= end) return 0;
        else if (height[start] == 0) return process(height, start + 1, end);
        else if (height[end] == 0) return process(height, start, end - 1);

        int area = Math.min(height[start], height[end]) * (end - start);
        int p1 = process(height, start + 1, end);
        int p2 = process(height, start, end - 1);
        int p3 = process(height, start + 1, end - 1);
        return Math.max(area, Math.max(p1, Math.max(p2, p3)));
    }


    //常规暴力
//    public int maxArea(int[] height){
//        int max = 0;
//        for(int i = 0; i < height.length; i++){
//            if (height[i] == 0) continue;
//            for(int j = i + 1; j < height.length; j++){
//                if (height[j] == 0) continue;
//                int area = Math.min(height[i], height[j]) * (j - i);
//                max= Math.max(max,area);
//            }
//        }
//        return max;
//    }

}
