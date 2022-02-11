package leetcode.digitalProblem;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args){
        int[] n={9,4,1,7};
        System.out.println(minimumDifference(n,2));
    }
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int start=0;
        int min=Integer.MAX_VALUE;
        for(int i = k-1; i < nums.length; i++){
            min=Math.min(min,Math.abs(nums[start++]-nums[i]));
        }
        return min;
    }
}
