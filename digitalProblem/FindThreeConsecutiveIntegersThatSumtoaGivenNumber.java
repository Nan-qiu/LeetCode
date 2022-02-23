package leetcode.digitalProblem;

import java.util.Arrays;

public class FindThreeConsecutiveIntegersThatSumtoaGivenNumber {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sumOfThree(21)));
    }
    public static long[] sumOfThree(long num) {
        if (num%3!=0) return new long[]{};
        long mid=num/3;
        return new long[]{mid-1,mid,mid+1};
    }
}
