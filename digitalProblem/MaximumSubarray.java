package leetcode.digitalProblem;

public class MaximumSubarray {
    public static void main(String[] args){
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] s = {-2, -1};
        System.out.println(maximumSubarray.maxSubArray1(s));
    }

    public int maxSubArray1(int[] nums){
        int sum = 0;
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum > 0){
                res = Math.max(res, sum);
            } else{
                res = Math.max(res, sum);
                sum = 0;
            }
        }
        return res;
    }

    public int maxSubArray(int[] nums){
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int start, int end){
        int res = 0;
        if (start > end) return 0;
        else if (start == end) return nums[start];
        else if (start + 1 == end) return nums[start] + nums[end];

        int p1 = process(nums, start + 1, end);
        int p2 = process(nums, start + 1, end - 1);
        int p3 = process(nums, start, end - 1);

        res = Math.max(p1, Math.max(p2, p3));
        return res;
    }

}
