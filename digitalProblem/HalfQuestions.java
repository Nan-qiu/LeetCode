package leetcode.digitalProblem;

import java.util.Arrays;

public class HalfQuestions {
    public static void main(String[] args){
        int[] a = {2,1,6,2};
        System.out.println(halfQuestions(a));
    }

    public static int halfQuestions(int[] questions){
        int[] ints = new int[1001];
        for(int a : questions){
            ints[a]++;
        }
        Arrays.sort(ints);
        int man = questions.length / 2;
        int res = 0;
        int sum=0;
        for(int i = 1000; i > 0; i--){
            if (ints[i] > 0){
                sum+=ints[i];
                res++;
                if (sum>=man) return res;
            }
        }
        return res;
    }
}
