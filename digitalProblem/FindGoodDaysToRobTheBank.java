package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    public static void main(String[] args){


        int[] n = {5,3,3,3,5,6,2};
        System.out.println(goodDaysToRobBank(n,2));
    }

    public static List<Integer> goodDaysToRobBank(int[] security,int time){
        if (security.length <= time * 2) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (time == 0){
            for(int i = 0; i < security.length; i++){
                res.add(i);
            }
            return res;
        }
        int[] left = new int[security.length];
        int[] right = new int[security.length];
        System.out.println("security = " + Arrays.toString(security));

        for(int i = 0; i < security.length - 1; i++){
            if (security[i] >= security[i + 1]) right[i + 1] = right[i] + 1;
        }

        for(int i = security.length - 1; i > 0; i--){
            if (security[i] >= security[i - 1]) left[i - 1] = left[i] + 1;
        }

        System.out.println("left = " + Arrays.toString(left));
        System.out.println("right = " + Arrays.toString(right));

        for(int i = time; i < security.length - time; i++){
            if (right[i] >= time && left[i] >= time) res.add(i);
        }
        return res;
    }
}
