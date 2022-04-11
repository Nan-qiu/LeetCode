package leetcode.digitalProblem;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args){
        JumpGameII jumpGameII = new JumpGameII();
        int[] a = {2,3,0,1,4};
        System.out.println(jumpGameII.jump1(a));
    }

    public int jump1(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return process(nums, 0,dp);
    }

    private int process(int[] nums, int index, int[] dp){
        if (index >= nums.length - 1) return 0;
        if (dp[index]!=-1) return dp[index];
        int step = Integer.MAX_VALUE-1;
        for(int i = 1; i <= nums[index]; i++){
            step = Math.min(step, 1 + process(nums, index + i, dp));
        }
        dp[index]=step;
        return step;
    }

    public int jump(int[] nums){
        if (nums.length == 1) return 0;
        else if (nums[0] >= nums.length - 1) return 1;
        int index = 0;
        int res = 0;
        while (index < nums.length) {
            int step = nums[index];
            int k = 0;
            int max = 0;
            for(int i = 1; i <= step; i++){
                if (i + index >= nums.length - 1) return res + 1;
                if (max <= nums[i + index]){
                    max = nums[i + index];
                    k = i;
                }
            }
            index += k;
            res++;
        }
        return res;
    }
}
