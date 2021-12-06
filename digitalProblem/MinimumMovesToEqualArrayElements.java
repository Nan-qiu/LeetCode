package leetcode.digitalProblem;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args){
        int[] a = {1,1000000000};
        System.out.println(minMoves(a));
    }

    public static int minMoves(int[] nums){
        if (nums.length < 2) return 0;
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for(int n : nums){
            res += n - min; // n-1个+1 -> 变为1个-1，最大值-1 ->
            // 反正都要--到和最小值相等，返回--的次数，不如直接用最小值减去每一个值，然后返回它们的和
        }
        return res;
    }
}
