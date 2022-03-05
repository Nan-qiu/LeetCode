package leetcode.digitalProblem;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums){
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[i]) max = Math.max(max,nums[j] - nums[i]);
            }
        }
        return max;
    }

    public int maximumDifference2(int[] nums){
        int maxDi = -1;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (min > nums[i]) min = nums[i];
            else maxDi = Math.max(maxDi,nums[i] - min);
        }
        return maxDi;
    }
}
