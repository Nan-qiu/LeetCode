package leetcode.digitalProblem;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts){
        int max = 0;
        for(int[] account : accounts){
            int sum = Arrays.stream(account).sum();
            max = Math.max(max, sum);
        }
        return max;
    }
}
