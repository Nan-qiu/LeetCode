package leetcode.stringProblem;

import java.util.Arrays;

public class InterleavingString {
    public static void main(String[] args){
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int[][] ints : dp){
            for(int[] anInt : ints){
                Arrays.fill(anInt,-1);
            }
        }
        return process1(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0,dp);
    }

    private boolean process1(char[] c1, char[] c2, char[] c3, int c1Index, int c2Index, int c3Index, int[][][] dp){
        if (dp[c1Index][c2Index][c3Index]!=-1){
            return dp[c1Index][c2Index][c3Index] == 1;
        }
        if (c3Index == c3.length) return true;
        boolean res = false;
        if (c1Index < c1.length && c1[c1Index] == c3[c3Index]){
            res = process1(c1, c2, c3, c1Index + 1, c2Index, c3Index + 1, dp);
        }
        if (c2Index < c2.length && c2[c2Index] == c3[c3Index]){
            res = res || process1(c1, c2, c3, c1Index, c2Index + 1, c3Index + 1, dp);
        }
        dp[c1Index][c2Index][c3Index]=res?1:0;
        return res;
    }

    private boolean process(char[] c1, char[] c2, char[] c3, int c1Index, int c2Index, int c3Index){
        if (c3Index == c3.length) return true;
        boolean res = false;
        if (c1Index < c1.length && c1[c1Index] == c3[c3Index]){
            res = process(c1, c2, c3, c1Index + 1, c2Index, c3Index + 1);
        }
        if (c2Index < c2.length && c2[c2Index] == c3[c3Index]){
            res = res || process(c1, c2, c3, c1Index, c2Index + 1, c3Index + 1);
        }
        return res;
    }
}
