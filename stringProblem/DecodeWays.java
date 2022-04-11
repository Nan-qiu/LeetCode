package leetcode.stringProblem;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args){
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12"));
    }

    public int numDecodings(String s){
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;
        return process1(s, 0, dp, s.length());
    }

    private int process1(String s, int start, int[] dp, int end){
        if (dp[start] != -1) return dp[start];
        if (start >= end) return 1;
        if (s.charAt(start) == '0'){
            dp[start] = 0;
            return 0;
        }
        int res = process1(s, start + 1, dp, end);
        if (start + 1 < end && (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) <= '6'))){
            res += process1(s, start + 2, dp, end);
        }
        dp[start] = res;
        return res;
    }

    private int process(String s, int start, int end){
        if (start >= end) return 1;
        if (s.charAt(start) == '0') return 0;
        int res = process(s, start + 1, end);
        if (start + 1 < end && (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) <= '6'))){
            res += process(s, start + 2, end);
        }
        return res;
    }

}
