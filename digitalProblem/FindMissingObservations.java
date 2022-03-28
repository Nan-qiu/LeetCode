package leetcode.digitalProblem;

import java.util.Arrays;

public class FindMissingObservations {

    public int[] missingRolls(int[] rolls,int mean,int n){
        int[] res = new int[n];
        int sum = (rolls.length + n) * mean;
        for(int roll : rolls){
            sum -= roll;
        }
        int k = sum / n;
        if (k <= 0 || k > 6) return new int[]{};
        else if (k * n == sum){
            Arrays.fill(res,k);
        } else{
            int i = sum - k * n;
            Arrays.fill(res,k);
            if (i > n) return new int[]{};
            else{
                for(int j = 0; j < i; j++){
                    res[j] += 1;
                }
            }
            if (res[0] > 6) return new int[]{};
        }
        return res;
    }
}
