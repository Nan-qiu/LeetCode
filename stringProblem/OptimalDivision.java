package leetcode.stringProblem;

public class OptimalDivision {
    public String optimalDivision(int[] nums){
        StringBuilder res = new StringBuilder();
        if (nums.length==1) return res.append(nums[0]).toString();
        if (nums.length==2) return res.append(nums[0]).append("/").append(nums[1]).toString();
        for(int i = 0; i < nums.length; i++){
            if (res.toString().equals("")) res.append(nums[i]).append("/").append("(");
            else if (i == nums.length - 1) res.append(nums[i]).append(")");
            else res.append(nums[i]).append("/");
        }
        return res.toString();
    }

}
