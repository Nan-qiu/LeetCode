package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitofPositiveEvenIntegers {
    public static void main(String[] args){
        System.out.println(maximumEvenSplit(12));
    }

    public static List<Long> maximumEvenSplit(long finalSum){
        ArrayList<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) return res;
        //long left = finalSum;
        long sum=0;
        long k = 0;
        int count=0;
        while (sum!=finalSum){
            k+=2;
            res.add(k);
            sum+=k;
            count++;
            if (sum==finalSum) return res;
            if (sum+k+2>finalSum){
                count--;
                Long remove = res.remove(count);
                sum-=remove;
            }
        }
        return res;
    }
}
