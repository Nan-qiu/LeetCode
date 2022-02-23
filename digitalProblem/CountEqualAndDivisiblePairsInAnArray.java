package leetcode.digitalProblem;

public class CountEqualAndDivisiblePairsInAnArray {

    public  int countPairs(int[] nums,int k){
        int res = 0;
        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j <nums.length; j++){
                if ((i * j) % k == 0){
                    res += nums[i] == nums[j] ? 1 : 0;
                }
            }
        }
        return res;
    }
}
