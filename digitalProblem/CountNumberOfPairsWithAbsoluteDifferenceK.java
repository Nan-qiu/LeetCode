package leetcode.digitalProblem;

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public static void main(String[] args){
        int[] n={3,2,1,5,4};
        System.out.println(countKDifference(n,2));
    }
    public static int countKDifference(int[] nums, int k) {
        int res=0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <nums.length ; j++){
                if (Math.abs(nums[i]-nums[j])==k) res++;
            }
        }
        return res;
    }
}
