package leetcode.digitalProblem;

public class TrappingRainWater {

    public int trap(int[] height){
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        int max = 0;

        for(int i = 0; i < height.length; i++){
            max = Math.max(max, height[i]);
            leftHighest[i] = max;
        }
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            rightHighest[i] = max;
        }
        int res = 0;
        for(int i = 1; i < height.length - 1; i++){
            if (height[i] < leftHighest[i] && height[i] < rightHighest[i]){
                res += Math.min(leftHighest[i], rightHighest[i]) - height[i];
            }
        }
        return res;
    }
}
