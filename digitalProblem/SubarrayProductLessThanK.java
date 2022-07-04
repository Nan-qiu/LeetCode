package leetcode.digitalProblem;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k){
        int res = 0;
        int i = 0, j;
        for(; i < nums.length; i++){
            int sum = 1;
            for(j = i; j < nums.length; j++){
                sum *= nums[j];
                if (sum < k) res++;
                else break;
            }
        }
        return res;
    }
}
