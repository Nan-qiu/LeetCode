package leetcode.digitalProblem;

public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int base=0;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            base+=i*nums[i];
        }

        int res=Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            base=base-(len-1)*nums[len-i-1]+sum-nums[len-i-1];
            res= Math.max(base,res);
        }
        return res;
    }
}
